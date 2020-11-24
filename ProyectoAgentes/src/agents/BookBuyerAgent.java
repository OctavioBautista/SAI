package agents;

import jade.core.Agent;
import behaviours.RequestPerformer;
import gui.BookBuyerGUI;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import java.awt.event.WindowEvent;

public class BookBuyerAgent extends Agent {

    private String bookTitle;
    private AID[] sellerAgents;
    private final int ticker_timer = 10000;
    private BookBuyerAgent this_agent = this;

    private BookBuyerGUI gui;

    protected void setup() {
        System.out.println("Agente comprador " + getAID().getName() + " esta listo");
        gui = new BookBuyerGUI(this);

        gui.setVisible(true);

        gui.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)  {
                this_agent.doDelete();
            }
        });
    }

    public void startLookingForABook() {
        bookTitle = getBookTitle();
        System.out.println("Libro: " + bookTitle);

        addBehaviour(new TickerBehaviour(this, ticker_timer) {
            protected void onTick() {
                String message = "Intentando comprar " + bookTitle + "\n";

                DFAgentDescription template = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType("book-selling");
                template.addServices(sd);

                try {
                    DFAgentDescription[] result = DFService.search(myAgent, template);
                    message += message.concat("Se encontraron los siguientes agentes vendedores:\n");
                    sellerAgents = new AID[result.length];
                    for (int i = 0; i < result.length; i++) {
                        sellerAgents[i] = result[i].getName();
                        message = message.concat(sellerAgents[i].getName() + "\n");
                    }
                    gui.updateLog(message);
                    message = "";
                } catch (FIPAException fe) {
                    fe.printStackTrace();
                }

                myAgent.addBehaviour(new RequestPerformer(this_agent));
            }
        });
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

    }

    public void close() {
        takeDown();
    }

    public AID[] getSellerAgents() {
        return sellerAgents;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBuyerAgentName() {
        return getAID().getName();
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookBuyerGUI getGui() {
        return gui; //To change body of generated methods, choose Tools | Templates.
    }

}
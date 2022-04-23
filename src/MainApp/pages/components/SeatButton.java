package MainApp.pages.components;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.*;

public class SeatButton extends JButton implements ActionListener {

    private boolean isOccupied = false;
    private boolean isChosen = false;
    
    private Seat seat;

    public SeatButton(int seatId) {
        super();
        GlobalData.data.put("lastChosenSeat", null);
        try {
            seat = Seat.getById(Seat.class, seatId);
            setText((String)seat.seatNo.getValue());
            this.isOccupied = seat.ticket.getValue() != null;
            setOccupied(this.isOccupied);
            setChosen(this.isChosen);
            addActionListener(this);
            // TODO: UI initialization

        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        if(isOccupied) {
            // TODO: UI changes
            setEnabled(false);
        } else {
            // TODO: UI changes
        }
    }

    private void setChosen(boolean isChosen) {
        this.isChosen = isChosen;
        if(isChosen) {
            var lastChoice = (SeatButton)GlobalData.data.get("lastChosenSeat");
            if(lastChoice != null) {
                lastChoice.setChosen(false);
            }
            GlobalData.data.put("lastChosenSeat", this);
            seat.ticket.setValue(((Ticket)GlobalData.data.get("ticket")).id);
            // TODO: UI changes
        } else {
            seat.ticket.setValue(null);
            // TODO: UI changes
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() != this) {
            return;
        }
        setChosen(true);
    }

    public static void saveChoice() {
        var seatBtn = (SeatButton)GlobalData.data.get("lastChosenSeat");
        if(seatBtn == null) {
            return;
        }
        seatBtn.seat.save();
    }

    public static void main(String[] args) {
        try {
            GlobalData.init(args);
            Models.init();
            GlobalData.data.put("ticket", Ticket.getById(Ticket.class, 1));
            var frame = new JFrame();
            var seats = Seat.queryByProperty(Seat.class, "interval", 1);
            frame.setLayout(new FlowLayout());
            for(var _seat: seats.toArray()) {
                var seat = (Seat)_seat;
                frame.add(new SeatButton(seat.id));
            }
            frame.add(new JButton("Next") {{
                var btn = this;
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource() != btn) {
                            return;
                        }
                        saveChoice();
                    }
                });
            }});
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (FieldNotFoundException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

}

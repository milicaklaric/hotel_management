/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this treslate file, choose Tools | Treslates
 * and open the treslate in the editor.
 */
package view.controller;

import controller.Controller;
import domen.GeneralDomainObject;
import domen.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.form.FrmCancelReservation;
import view.form.table.ReservationsTableModel;

/**
 *
 * @author MK
 */
public class CancelReservationController {

    private final FrmCancelReservation frmCancelReservation;

    public CancelReservationController(FrmCancelReservation frmCancelReservation) {
        this.frmCancelReservation = frmCancelReservation;
        addListeners();
    }

    public FrmCancelReservation getpnlAllReservations() {
        return frmCancelReservation;
    }

    public void show() {
        frmCancelReservation.setVisible(true);
    }

    private void addListeners() {
        frmCancelReservation.btnFindAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<GeneralDomainObject> r = Controller.getInstance().getReservations();
                ArrayList<Reservation> ress = new ArrayList<>();
                for (int i = 0; i < r.size(); i++) {
                    Reservation res = (Reservation) r.get(i);
                    ress.add(res);
                }

                frmCancelReservation.setTable(ress);
            }

        });
        frmCancelReservation.btnCancelAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = frmCancelReservation.getTblReservations().getSelectedRow();
                ReservationsTableModel rtm = (ReservationsTableModel) frmCancelReservation.getTblReservations().getModel();
                Reservation res = rtm.getReservationAt(row);
                if (Controller.getInstance().deleteReservation(res)) {
                    JOptionPane.showMessageDialog(frmCancelReservation, "Reservation successfully canceled!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frmCancelReservation, "Couldn't cancel reservation", "Fail", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
    }
}

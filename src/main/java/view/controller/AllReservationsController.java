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
import java.util.Date;
import view.form.FrmAllReservations;

/**
 *
 * @author MK
 */
public class AllReservationsController {

    private final FrmAllReservations frmAllReservations;

    public AllReservationsController(FrmAllReservations frmAllReservations) {
        this.frmAllReservations = frmAllReservations;
        addListeners();
    }

    public FrmAllReservations getpnlAllReservations() {
        return frmAllReservations;
    }

    public void show() {
        frmAllReservations.setVisible(true);
    }

    private void addListeners() {
        frmAllReservations.btnFindAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<GeneralDomainObject> r = Controller.getInstance().getReservations();
                ArrayList<Reservation> ress = new ArrayList<>();

                if (frmAllReservations.getFilter().isSelected()) {
                    Date from = frmAllReservations.getFromDate().getDate();
                    Date to = frmAllReservations.getToDate().getDate();
                    for (int i = 0; i < r.size(); i++) {
                        Reservation res = (Reservation) r.get(i);
                        if (res.getCheckOut().before(from) || res.getCheckIn().after(to)) {
                            r.remove(res);
                        }
                    }
                }

                for (int i = 0; i < r.size(); i++) {
                    Reservation res = (Reservation) r.get(i);
                    ress.add(res);
                }

                frmAllReservations.setTable(ress);
            }

        });
    }
}

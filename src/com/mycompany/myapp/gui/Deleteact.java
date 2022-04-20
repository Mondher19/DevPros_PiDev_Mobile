/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Act;
import com.mycompany.myapp.services.ServiceAct;

/**
 *
 * @author yassine
 */
public class Deleteact extends Form{
    public Deleteact(Act p, Form previous) {
      //  setTitle("delete Personne");
        

        Button btnSubmit = new Button("supprimer");
        Button btnret = new Button("retourner");
        
            //btnret.addActionListener(e -> new HomeForm(p).show());
        
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    Dialog.show("Alert", "Etes-vous sure !!", new Command("OK"));
             
                    System.out.println(p.getId());
                    System.out.println("deleted actualités");
                    
                    if (ServiceAct.getInstance().Delete(p)) {
                        Dialog.show("Success", "Connection Accepted", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Connection Failed", new Command("OK"));
                    }
                        
                }
      
        });
        

        addAll(btnSubmit);
      this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }




    
}

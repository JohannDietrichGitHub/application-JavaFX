package com.example.appfx;

import javafx.scene.control.TextArea;

public class ShowContactManager {
    private ContactsManager ContactsManager;
    private TextArea contenu_Contact_Area;

    public ShowContactManager(ContactsManager ContactsManager, TextArea contenu_Contact_Area) {
        this.ContactsManager = ContactsManager;
        this.contenu_Contact_Area = contenu_Contact_Area;
    }

    public void showContact() {
        String selectedContact = ContactsManager.getContact();
        int contactId = ContactsManager.getContactId(); // Utilisez une méthode pour obtenir l'identifiant du contact à partir du sujet

        Contact contact = ContactsManager.getContactDetails(contactId); // Utilisez l'identifiant pour récupérer les détails du contact

        // Récupérer les détails du contact à partir de ContactsManager
        Contact contact2 = ContactsManager.getContactDetails(contactId);

        if (contact2 != null) {
            System.out.println("Mail: " + contact.getMail());

            contenu_Contact_Area.setText(contact.getRaison());

        } else {
            System.out.println("Contact non trouvé");
        }
    }
}

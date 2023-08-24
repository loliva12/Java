package main;

import views.LoginView; //importamos al archivo del login

public class main {
    public static void main(String[] args) {  //psvm tab 
        //instancia del Login
        LoginView login = new LoginView(); //creacion del objeto
        login.setVisible(true); //para que el objeto este visible
    }
}

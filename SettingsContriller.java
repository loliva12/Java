package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static models.EmployeesDao.address_user;
import static models.EmployeesDao.email_user;
import static models.EmployeesDao.full_name_user;
import static models.EmployeesDao.id_user;
import static models.EmployeesDao.telephone_user;
import views.SystemView;

public class SettingsContriller implements MouseListener {
    
    private SystemView views;   //instanciar la vista
    
    public SettingsContriller(SystemView views){  //constructor
        this.views = views; 
        //colocar en escucha
        this.views.jLabelProducts.addMouseListener(this);
        this.views.jLabelCategories.addMouseListener(this);
        this.views.jLabelCustomers.addMouseListener(this);
        this.views.jLabelEmployees.addMouseListener(this);
        this.views.jLabelPurchases.addMouseListener(this);
        this.views.jLabelReports.addMouseListener(this);
        this.views.jLabelSettings.addMouseListener(this);
        this.views.jLabelSuppliers.addMouseListener(this);  
        Profile();
    }
    
    //asignar el perfil del usuario
    public void Profile(){
        this.views.txt_id_profile.setText("" + id_user);
        this.views.txt_name_profile.setText(full_name_user);
        this.views.txt_address_profile.setText(address_user);
        this.views.txt_phone_profile.setText(telephone_user); 
        this.views.txt_email_profile.setText(email_user); 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == views.jLabelProducts){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelProducts.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelCategories){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelCategories.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelCustomers){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelCustomers.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelEmployees){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelEmployees.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelPurchases){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelPurchases.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelReports){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelReports.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelSettings){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelSettings.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelSuppliers){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelSuppliers.setBackground(new Color(152, 202, 63)); //entonces cambia el color del fondo del panel
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == views.jLabelProducts){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelProducts.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelCategories){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelCategories.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelCustomers){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelCustomers.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelEmployees){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelEmployees.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelPurchases){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelPurchases.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelReports){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelReports.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelSettings){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelSettings.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
        if(e.getSource() == views.jLabelSuppliers){ //si le mouse del usuario se encurnta ensima del jLabelProducts 
            views.jPanelSuppliers.setBackground(new Color(0,104, 55)); //entonces cambia el color del fondo del panel
        }
    }
    
}

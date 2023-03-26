/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.ramananjato.tp1.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mg.itu.ramananjato.tp1.ejb.DiscountManager;
import mg.itu.ramananjato.tp1.entities.Discount;

/**
 *
 * @author h.ramananjato
 */
@FacesConverter(value = "discountConverter", managed = true)
public class DiscountConverter implements Converter<Discount> {
    @EJB
    private DiscountManager discountManager;

    /**
     * Conversion String to Discount
     * 
     * @param fc
     * @param uic
     * @param value
     * @return 
     */
    @Override
    public Discount getAsObject(FacesContext fc, UIComponent uic, String value) {
        return (value == null) ? null : discountManager.findById(value);
    }

    /**
     * Converstion Discount to String
     * 
     * @param fc
     * @param uic
     * @param discount
     * @return 
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Discount discount) {
        return (discount == null) ? "" : discount.getCode();
    }

}

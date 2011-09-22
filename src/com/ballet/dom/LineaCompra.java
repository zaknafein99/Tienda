                    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.dom;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Isma
 */
@Entity
public class LineaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer cantidad;
    private float precioCompra;
    @ManyToOne
    private Producto producto = new Producto();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaComp;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaCompra)) {
            return false;
        }
        LineaCompra other = (LineaCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.cantidad + " - " + this.producto.toString();
    }

    /**
     * @return the descripcion
     */
   
    /**
     * @return the fechaComp
     */
    public Date getFechaComp() {
        return fechaComp;
    }

    /**
     * @param fechaComp the fechaComp to set
     */
    public void setFechaComp(Date fechaComp) {
        this.fechaComp = fechaComp;
    }

    
    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the precioCompra
     */
    public float getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

       
}

package com.springapp.dao;

import com.heroku.sdk.jdbc.DatabaseUrl;
import com.springapp.model.Address;
import com.springapp.model.Supplier;
import com.springapp.model.ProductSupplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SuppliersDaoImp implements SuppliersDao {


    public Supplier getSupplierbyId(int supplierId) {
        Connection connection = null;
        Supplier supplier;
        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM suppliers WHERE id = " + supplierId;
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                supplier = new ProductSupplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        new Address(
                                rs.getString("addressLine1"),
                                rs.getString("addressLine2"),
                                rs.getString("addressLine3"),
                                rs.getString("city"),
                                rs.getString("postcode")
                        ),
                        rs.getString("contactNumber"),
                        rs.getString("email")
                );
            }
            else{
                supplier = null;
            }
        } catch (Exception e){
            supplier = null;
        }
        finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }

        return supplier;
    }


    public ArrayList<Supplier> getAllSuppliers(){
        Connection connection = null;
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM suppliers";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){

                Supplier supplier = new ProductSupplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        new Address(
                                rs.getString("addressLine1"),
                                rs.getString("addressLine2"),
                                rs.getString("addressLine3"),
                                rs.getString("city"),
                                rs.getString("postcode")
                        ),
                        rs.getString("contactNumber"),
                        rs.getString("email")
                );
                suppliers.add(supplier);
            }
        } catch (Exception e){

        }
        finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
        return suppliers;
    }

    @Override
    public Supplier createSupplier(ProductSupplier supplier) {
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO suppliers(id, addressline1, addressline2, addressline3, cityid, postcode, contactNumber, name, email)"
                    + "VALUES ('" + supplier.getSupplierId() + " ', "
                    + supplier.getAddress().getAddressLine1() + "', '"
                    + supplier.getAddress().getAddressLine2() + "', '"
                    + supplier.getAddress().getAddressLine3() + "', '"
                    + supplier.getAddress().getCity() + "', '"
                    + supplier.getAddress().getPostcode() + "', '"
                    + supplier.getContactNumber() + "', '"
                    + supplier.getName() + "', '"
                    + supplier.getEmailAddress() + "')";
            stmt.executeQuery(query);
        } catch (Exception e){
        }
        finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }

        return supplier;
    }

    public void deleteSupplier(ProductSupplier supplier) {
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM suppliers WHERE id =" + supplier.getSupplierId();
            stmt.executeQuery(query);
        } catch (Exception e){

        }
        finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
    }

    public Supplier cancelSupplier(ProductSupplier supplier) {
        cancelSupplier(supplier.getSupplierId());
        return supplier;
    }

    public Boolean cancelSupplier(int supplierId) {
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE suppliers SET active= false WHERE id=" + supplierId;
            stmt.executeQuery(query);
        } catch (Exception e){

        }
        finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
        return true;
    }

    public Supplier updateSupplier(ProductSupplier supplier) {
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE suppliers SET "
                    + "addressline1= '" + supplier.getAddress().getAddressLine1() + "', "
                    + "addressline2= '" + supplier.getAddress().getAddressLine2() + "', "
                    + "addressline3= '" + supplier.getAddress().getAddressLine3() + "', "
                    + "cityid= '" + supplier.getAddress().getCity() + "', "
                    + "postcode= '"  + supplier.getAddress().getPostcode() + "', "
                    + "contactNumber= '"  + supplier.getContactNumber() + "', "
                    + "name= '" + supplier.getName() + "', "
                    + "email= '" + supplier.getEmailAddress()
                    + " WHERE id=" + supplier.getSupplierId();
            stmt.executeQuery(query);
        } catch (Exception e){

        }
        finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
        return supplier;
    }
}

package com.springapp.model;

public class ProductSupplier implements Supplier {

        private int supplierId;
        private String name;
        private Address address;
        private String contactNumber;
        private String emailAddress;

        public ProductSupplier(String name, Address address, String contactNumber, String emailAddress) {

                this.name = name;
                this.address = address;
                this.contactNumber = contactNumber;
                this.emailAddress = emailAddress;
        }

        public ProductSupplier(int supplierId, String name, Address address, String contactNumber, String emailAddress) {

                this.supplierId = supplierId;
                this.name = name;
                this.address = address;
                this.contactNumber = contactNumber;
                this.emailAddress = emailAddress;
        }

        public int getSupplierId() {
                return supplierId;
        }

        public void setSupplierId(int supplierId) {
                this.supplierId = supplierId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Address getAddress() {
                return address;
        }

        public void setAddress(Address address) {
                this.address = address;
        }

        public String getContactNumber() {
                return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
        }

        public String getEmailAddress() {
                return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
        }
}
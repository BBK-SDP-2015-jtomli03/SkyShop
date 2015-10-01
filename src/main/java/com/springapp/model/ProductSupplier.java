package com.springapp.model;

/**
 * Created by Jo on 27/09/2015.
 */
public class ProductSupplier  implements Supplier{
        private int id;
        private String companyName;
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private int cityId;
        private String postCode;
        private String landLinePhoneNumber;

        @Override
        public String getAddress() {
            return null;
        }
}

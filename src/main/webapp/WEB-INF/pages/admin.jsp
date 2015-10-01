<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<html>
  <head>
        <!-- FONTS -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS -->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.css"/>

        <!-- JS -->
        <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>
        <title>Admin</title>
  </head>

    <body>
        <nav class="blue darken-1" role="navigation">
            <div class="nav-wrapper container">
                <a id="logo-container" href="#" class="brand-logo">SkyShop Admin</a>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <br><br>

                <div class="col s8 offset-s2">
                    <div class="row">

                        <!-- ADMIN HEADERS -->
                        <div>
                            <ul class="tabs">
                                <li class="tab col s2"><a class="teal-text" href="#product-admin">Product</a></li>
                                <li class="tab col s2"><a class="teal-text active" href="#employee-admin">Employee</a></li>
                                <li class="tab col s2"><a class="teal-text" href="#customer-admin">Customer</a></li>
                                <li class="tab col s2"><a class="teal-text" href="#order-admin">Order</a></li>
                                <li class="tab col s2"><a class="teal-text" href="#supplier-admin">Supplier</a></li>
                            </ul>
                        </div>

                        <br>

                        <!-- PRODUCT FORMS -->
                        <ul id="product-admin" class="collapsible" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header"><i class="material-icons">search</i>Search Products</div>
                                <div class="collapsible-body">
                                    <div class="container col s12">
                                        <form class="col s12">
                                            <input id="product_search" type="text" class="validate">
                                            <label for="product_search">Search Products</label>
                                            <div class="row">
                                                <button class="waves-effect waves-teal btn right">
                                                    SEARCH<i class="material-icons right">search</i>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="collapsible-header"><i class="material-icons">add</i>Add New</div>
                                <div class="collapsible-body">
                                    <div class="container">
                                        
                                    <br>
                                        <div class="row">
                                            <form class="col s12">
                                                <div class="row">
                                                    <div class="input-field col s9">
                                                        <input id="product_name" type="text" class="validate">
                                                        <label for="product_name">Product Name</label>
                                                    </div>
                                                    <div class="input-field col s3">
                                                      <input id="product_price" type="text" class="validate">
                                                      <label for="product_price">Price(&#163;)</label>
                                                    </div>
                                                </div>
                                              
                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <textarea id="product_description" class="materialize-textarea"></textarea>
                                                        <label for="product_description">Description</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="product_supplier" type="text" class="validate">
                                                        <label for="product_supplier">Supplier</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="product_code" type="text" class="validate">
                                                        <label for="product_code">Product Code</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <button class="waves-effect waves-teal btn right">
                                                        ADD<i class="material-icons right">done</i>
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                         </ul>

                         <!-- EMPLOYEE FORMS -->
                        
                        <!-- EMPLOYEE FORMS -->
                        <ul id="employee-admin" class="collapsible" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header"><i class="material-icons">search</i>Search Employees</div>

                                <div class="collapsible-body">
                                    <div class="container col s12">
                                        <form class="col s12">
                                            <div class="row">
                                                <div class="input-field">
                                                    <input id="employee_search" type="text" class="validate">
                                                    <label for="employee_search">Search Employees</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <button class="waves-effect waves-teal btn right">
                                                    SEARCH<i class="material-icons right">search</i>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>

                            <li><!-- ADD NEW EMPLOYEE -->
                                <div class="collapsible-header"><i class="material-icons">perm_identity</i>Add New</div>

                                <div class="collapsible-body">
                                    <div class="container"><br>
                                        <div class="row">
                                            <form class="col s12">

                                                <div class="row">
                                                    <div class="input-field col s6">
                                                        <input id="employee_forename" type="text" class="validate">
                                                        <label for="employee_forename">Forename</label>
                                                    </div>
                                             
                                                    <div class="input-field col s6">
                                                        <input id="employee_surname" type="text" class="validate">
                                                        <label for="employee_surname">Surname</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field">
                                                        <!-- TODO: Change this to dropdown of all apartments -->
                                                        <input id="employee_department" type="text" class="validate">
                                                        <label for="employee_department">Department</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="employee_address1" type="text" class="validate">
                                                        <label for="employee_address1">Address Line 1</label>
                                                    </div>
                                   
                                                    <div class="input-field col s12">
                                                        <input id="employee_address2" type="text" class="validate">
                                                        <label for="employee_address2">Address Line 2</label>
                                                    </div>
                                      
                                                    <div class="input-field col s12">
                                                        <input id="employee_address3" type="text" class="validate">
                                                        <label for="employee_address3">Address Line 3</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="employee_city" type="text" class="validate">
                                                        <label for="employee_city">City</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s6">
                                                        <input id="employee_landline" type="text" class="validate">
                                                        <label for="employee_landline">Landline</label>
                                                    </div>
                                             
                                                    <div class="input-field col s6">
                                                        <input id="employee_mobile" type="text" class="validate">
                                                        <label for="employee_mobile">Mobile</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s6">
                                                        <input id="employee_username" type="text" class="validate">
                                                        <label for="employee_username">Username</label>
                                                    </div>
                                              
                                                    <div class="input-field col s6">
                                                        <input id="employee_password" type="password" class="validate">
                                                        <label for="employee_password">Password</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="employee_access" type="text" class="validate">
                                                        <label for="employee_access">Access Level</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <button class="waves-effect waves-teal btn right">
                                                            ADD<i class="material-icons right">done</i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>

                        <!-- CUSTOMER FORMS -->
                        <ul id="customer-admin" class="collapsible" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header"><i class="material-icons">search</i>Search</div>
                                <div class="collapsible-body">
                                    <div class="container col s12">
                                        <form class="col s12">
                                            <input id="product_search" type="text" class="validate">
                                            <label for="product_search">Search Products</label>
                                            <div class="row">
                                                <button class="waves-effect waves-teal btn right">
                                                    SEARCH<i class="material-icons right">search</i>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>

                            <li><!-- ADD NEW CUSTOMER -->
                                <div class="collapsible-header"><i class="material-icons">perm_identity</i>Add New</div>

                                <div class="collapsible-body">
                                    <div class="container"><br>
                                        <div class="row">
                                            <form class="col s12">

                                                <div class="row">
                                                    <div class="input-field col s2">
                                                        <input id="customer_title" type="text" class="validate">
                                                        <label for="customer_title">Title</label>
                                                    </div>

                                                    <div class="input-field col s5">
                                                        <input id="customer_forename" type="text" class="validate">
                                                        <label for="customer_forename">Forename</label>
                                                    </div>
                                             
                                                    <div class="input-field col s5">
                                                        <input id="customer_surname" type="text" class="validate">
                                                        <label for="customer_surname">Surname</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="customer_address1" type="text" class="validate">
                                                        <label for="customer_address1">Address Line 1</label>
                                                    </div>
                                   
                                                    <div class="input-field col s12">
                                                        <input id="customer_address2" type="text" class="validate">
                                                        <label for="customer_address2">Address Line 2</label>
                                                    </div>
                                      
                                                    <div class="input-field col s12">
                                                        <input id="customer_address3" type="text" class="validate">
                                                        <label for="customer_address3">Address Line 3</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="customer_city" type="text" class="validate">
                                                        <label for="customer_city">City</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s6">
                                                        <input id="customer_landline" type="text" class="validate">
                                                        <label for="customer_landline">Landline</label>
                                                    </div>
                                             
                                                    <div class="input-field col s6">
                                                        <input id="customer_mobile" type="text" class="validate">
                                                        <label for="customer_mobile">Mobile</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s6">
                                                        <input id="customer_username" type="text" class="validate">
                                                        <label for="customer_username">Username</label>
                                                    </div>
                                              
                                                    <div class="input-field col s6">
                                                        <input id="customer_password" type="password" class="validate">
                                                        <label for="customer_password">Password</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <button class="waves-effect waves-teal btn right">
                                                            ADD<i class="material-icons right">done</i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>

                        <!-- ORDER FORMS -->
                        <ul id="order-admin" class="collapsible" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header"><i class="material-icons">search</i>Search Orders</div>
                                <div class="collapsible-body">
                                    <div class="container col s12">
                                        <form class="col s12">
                                            <input id="order_search" type="text" class="validate">
                                            <label for="order_search">Search Orders</label>
                                            <div class="row">
                                                <button class="waves-effect waves-teal btn right">
                                                    SEARCH<i class="material-icons right">search</i>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>

                            <li><!-- ADD NEW ORDER -->
                                <div class="collapsible-header"><i class="material-icons">shopping_cart</i>Add New</div>

                                <div class="collapsible-body">
                                    <div class="container"><br>
                                        <div class="row">
                                            <form class="col s12">

                                                <div class="row">
                                                    <div class="input-field col s6">
                                                        <input id="order_customer_id" type="text" class="validate">
                                                        <label for="order_customer_id">Customer ID</label>
                                                    </div>

                                                    <div class="input-field col s6">
                                                        <input id="customer_forename" type="text" class="validate">
                                                        <label for="customer_forename">Forename</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="customer_address1" type="text" class="validate">
                                                        <label for="customer_address1">Address Line 1</label>
                                                    </div>
                                   
                                                    <div class="input-field col s12">
                                                        <input id="customer_address2" type="text" class="validate">
                                                        <label for="customer_address2">Address Line 2</label>
                                                    </div>
                                      
                                                    <div class="input-field col s12">
                                                        <input id="customer_address3" type="text" class="validate">
                                                        <label for="customer_address3">Address Line 3</label>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <input id="customer_city" type="text" class="validate">
                                                        <label for="customer_city">City</label>
                                                    </div>
                                                </div>

                               

                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <button class="waves-effect waves-teal btn right">
                                                            PLACE<i class="material-icons right">shopping_basket</i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>

                        <!-- SUPPLIER FORMS -->
                        <ul id="supplier-admin" class="collapsible" data-collapsible="accordion">

                        </ul>

                    </div>
                </div>
            </div><!-- div.row -->
        </div><!-- div.container -->
    </body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="modules/header.jsp" />
<jsp:include page="modules/remote.jsp" />

<div class="section">
</div>
<div class="product row">
  <div class="col s12 m4 offset-m1 z-depth-2 blue-grey lighten-3">
    <img class="materialboxed" src="<spring:url value="/resources/img/box.jpg" />">
    <div class="section"></div>
    <div class="center">
      <button class="btn-floating btn-large waves-effect waves-light red modal-trigger" onclick="$('#modal1').openModal();"><i class="material-icons">shopping_basket</i></button>

      <!-- Modal Structure -->
      <div id="modal1" class="modal">
        <div class="modal-content">
          <div class="row">
            <div class="col s6">
              <h4 id="prodName" class="teal-text">Purchase Item Name</h4>
            </div>
            <div class="col s6">
              <h4 id="prodValue" class="teal-text">&pound;4.99</h4>
            </div>
          </div>
          <div>
            <div class="col s12"></div>
              <form id="add-product" action="/basket" >
                <div class="input-field col s6">
                  <input id="id" value="1" class="hide">
                  <select id="number">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                  </select>
                  <label>Select Quantity</label>
                </div>
                <div class="input-field col s6">
                  <button type="submit" class="waves-effect waves-light btn"><i class="material-icons left">shopping_basket</i>Add to Basket</button>
                </div>
              </form>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <div class="modal-banner">
          </div>
          <a href="#" class=" modal-action modal-close waves-effect waves-green btn-flat large">
            <i class="material-icons">close</i></a>
        </div>
      </div>


      <!-- Dropdown Trigger -->
      <a class='dropdown-button btn btn-floating btn-large waves-effect waves-light blue' href='#' data-activates='dropdown1'>
        <i class="mdi-social-share"></i>
      </a>

      <!-- Dropdown Structure -->
      <!--
      <ul id='dropdown1' class='dropdown-buttons'>
        <li><a class="btn-floating btn-large red"></a></li>
        <li><a class="btn-floating btn-large yellow darken-1"></a></li>
        <li><a class="btn-floating btn-large green"></a></li>
        <li><a class="btn-floating btn-large blue"><i class="mdi mdi-facebook"></i></a></li>
      </ul>
      -->

    </div>
    <div class="section"></div>
  </div>
  <div class="col s12 m5 offset-m1">
    <h3 class="header blue-grey-text">Product Name</h3>
      <hr>
      <p>Long product description... Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
      </p>
      <h4 class="right orange-text">&pound;4.99</h4>
  </div>
</div>
<div class="section">
</div>

<hr>

<div class="section">
</div>

<div class="row">
  <h4 class="center">Similar Products</h4>
  <div class="section"></div>
  <div class="col l3 s6">
    <div class="card hoverable">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
  <div class="col l3 s6">
    <div class="card hoverable">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
  <div class="col l3 s6">
    <div class="card hoverable">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
  <div class="col l3 s6">
    <div class="card hoverable">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
</div>
<div class="section">
</div>

<jsp:include page="modules/gnome.jsp" />
<jsp:include page="modules/bestsellers.jsp" />
<jsp:include page="modules/footer.jsp" />
<script type="application/javascript">
  $(document).ready(function() {
    $('select').material_select();
    $( "#add-product" ).submit(function( event ) {
      var prodName = $(this).parent().parent().find('#prodName').html();
      var prodVal = $(this).parent().parent().find('#prodValue').html();
      var val = Number(prodVal.replace(/[^0-9\.]+/g,""));
      var num = $('#number').val();
      var id = $('#id').val();
      addToCart(prodName,val,num,id);
    });
  });
</script>
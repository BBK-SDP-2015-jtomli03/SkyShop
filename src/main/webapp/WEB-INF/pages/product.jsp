<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="modules/header.jsp" />
<jsp:include page="modules/remote.jsp" />

<div class="section">
</div>
<div class="product row">
  <div class="col s12 m5 l4 offset-l1 z-depth-2 blue-grey lighten-3">
    <img class="materialboxed" src="<spring:url value="/resources/img/box.jpg" />">
    <div class="section"></div>
    <div class="center">
      <button class="btn-floating btn-large waves-effect waves-light red modal-trigger" onclick="$('#modal1').openModal();"><i class="material-icons">shopping_basket</i></button>

      <!-- Modal Structure -->
      <div id="modal1" class="modal">
        <div class="modal-content">
          <h4 class="teal-text">Purchase Item Name</h4>
            <div class="col s12"></div>
              <form>
                <div class="input-field col s6">
                  <select>
                    <option value="" disabled selected>Choose your option</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                  </select>
                  <label>Select Quantity</label>
                </div>
                <div class="input-field col s6">
                  <a class="waves-effect waves-light btn"><i class="material-icons left">shopping_basket</i>Add to Basket</a>
                </div>
              </form>
            </div>
        </div>
        <div class="modal-footer">
          <div class="modal-banner">
          </div>
          <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat large"><i class="material-icons">close</i></a>
        </div>
      </div>


      <!-- Dropdown Trigger -->
      <a class='dropdown-button btn btn-floating btn-large waves-effect waves-light blue' href='#' data-activates='dropdown1'>
        <i class="mdi-social-share"></i>
      </a>

      <!-- Dropdown Structure -->
      <ul id='dropdown1' class='dropdown-buttons'>
        <li><a class="btn-floating red"></a></li>
        <li><a class="btn-floating yellow darken-1"></a></li>
        <li><a class="btn-floating green"></a></li>
        <li><a class="btn-floating blue"></a></li>
      </ul>

    </div>
    <div class="section"></div>
  </div>
  <div class="col s12 m7 offset-l1 l5">
    <h3 class="header blue-grey-text">Product Name</h3>
      <hr>
      <p>Long product description... Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
      </p>
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
    <div class="card">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
  <div class="col l3 s6">
    <div class="card">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
  <div class="col l3 s6">
    <div class="card">
      <div class="card-image waves-effect waves-block waves-light">
        <img src="<spring:url value="/resources/img/gnome.JPG" />">
          <span class="card-title">Product Title
              <a class="btn-floating waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
          </span>
      </div>
    </div>
  </div>
  <div class="col l3 s6">
    <div class="card">
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
  });
</script>
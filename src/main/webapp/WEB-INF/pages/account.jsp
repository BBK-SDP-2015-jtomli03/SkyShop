<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="modules/header.jsp" />
<jsp:include page="modules/remote.jsp" />

<div class="section">
</div>
<div class="row">
  <div class="col s12">
    <ul class="tabs">
      <li class="tab col s3"><a class="active" href="#general">General</a></li>
      <li class="tab col s3"><a href="#address">Address</a></li>
      <li class="tab col s3"><a href="#preferences">Preferences</a></li>
    </ul>
  </div>
  <form class="col m12"  method="POST" action="/customer/new">
    <div id="general" class="col s10 offset-s1">
      <h3 class="header blue-grey-text">General</h3>
      <hr>
      <div class="section"></div>

      <div class="input-field col m6 s12">
        <div class="input-field col s12">
          <select>
            <option value="" selected disabled>Choose a title</option>
            <option value="1">Dr</option>
            <option value="2">Miss</option>
            <option value="3">Mr</option>
            <option value="4">Mrs</option>
            <option value="5">Ms</option>
            <option value="6">Other</option>
          </select>
          <label>Title</label>
        </div>

        <div style="clear:both;"></div>
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i>
          <input id="first_name" type="text" class="validate" path="firstName"/>
          <label for="first_name">First Name</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i>
          <input id="second_name" type="text" class="validate">
          <label for="second_name">Second Name</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i>
          <input id="user" type="text" class="validate">
          <label for="user">Username</label>
        </div>
      </div>
      <div class="input-field col m6 s12">
        <div class="input-field col s12">
          <i class="material-icons prefix">email</i>
          <input id="email" type="email" class="validate">
          <label for="email">Email</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">email</i>
          <input id="email_2" type="email" class="validate">
          <label for="email_2">Retype Email</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">lock</i>
          <input id="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">lock</i>
          <input id="password_2" type="password" class="validate">
          <label for="password_2">Password</label>
        </div>
      </div>
      <br style="clear:both;" />
      <br style="clear:both;" />
      <br style="clear:both;" />
      <a class="btn waves-effect waves-light red right" ONCLICK="changeTab('address')">Next
        <i class="material-icons right">send</i>
      </a>

    </div>
    <div id="address" class="col s10 offset-s1">
      <h3 class="header blue-grey-text">Address</h3>
      <hr>
      <div class="section"></div>
      <!--
      <div class="input-field col m6 s12">
        <div class="input-field col s12">
          <i class="material-icons prefix">home</i>
          <input id="street_address" type="text" class="validate">
          <label for="street_address">Street Number/House Name</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">home</i>
          <input id="street_address" type="text" class="validate">
          <label for="street_address">Postcode</label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
        <div class="center">
          <button class="btn waves-effect waves-light green" type="submit" name="action">Find Address
            <i class="material-icons right">send</i>
          </button>
        </div>
      </div>-->
      <div class="input-field col m6 s12">
        <div class="input-field col s12">
          <i class="material-icons prefix">home</i>
          <input id="line1" type="text" class="validate">
          <label for="line1">Address 1</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">directions_car</i>
          <input id="line2" type="text" class="validate">
          <label for="line2">Address 2</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">local_gas_station</i>
          <input id="city" type="text" class="validate">
          <label for="city">Town/City</label>
        </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">terrain</i>
          <input id="county" type="text" class="validate">
          <label for="county">County</label>
        </div>
      </div>
      <div class="input-field col m6 s12">
        <div class="input-field col s12">
          <i class="material-icons prefix">location_searching </i>
          <input id="postcode" type="text" class="validate">
          <label for="postcode">Postcode</label>
        </div>
      </div>
      <br style="clear:both;" />
      <br style="clear:both;" />
      <br style="clear:both;" />
      <a class="btn waves-effect waves-light red left" ONCLICK="changeTab('general')">Back
        <i class="material-icons left mirror">send</i>
      </a>
      <a class="btn waves-effect waves-light red right" ONCLICK="changeTab('preferences')">Next
        <i class="material-icons right">send</i>
      </a>


    </div>
    <div id="preferences" class="col s10 offset-s1">
      <h3 class="header blue-grey-text">Preferences</h3>
      <hr>
      <div class="section"></div>
      <div class="input-field col m6 s12">
        <h4 class="header blue-grey-text">Notifications</h4>
        <hr>
        <p>Choose how we get in touch with you regrarding orders and dispatches.</p>
        <div class="input-field switch col s12">
          <label>
            Email:
            <input type="checkbox">
            <span class="lever right"></span>
          </label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
        <div class="input-field switch col s12">
          <label>
            SMS:
            <input type="checkbox">
            <span class="lever right"></span>
          </label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
        <div class="input-field switch col s12">
          <label>
            Post:
            <input type="checkbox">
            <span class="lever right"></span>
          </label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
      </div>
      <div class="input-field col m6 s12">
        <h4 class="header blue-grey-text">Special Offers</h4>
        <hr>
        <p>Sometimes we might get in contact with you with offers we think you'd like. Choose how you receive these deals.</p>
        <div class="input-field switch col s12">
          <label>
            Email:
            <input type="checkbox">
            <span class="lever right"></span>
          </label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
        <div class="input-field switch col s12">
          <label>
            SMS:
            <input type="checkbox">
            <span class="lever right"></span>
          </label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
        <div class="input-field switch col s12">
          <label>
            Post:
            <input type="checkbox">
            <span class="lever right"></span>
          </label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
      </div>
      <br style="clear:both;" />
      <br style="clear:both;" />
      <br style="clear:both;" />
      <a class="btn waves-effect waves-light red left" ONCLICK="changeTab('address')">Back
        <i class="material-icons left mirror">send</i>
      </a>
      <button class="btn waves-effect waves-light green right" type="submit" value="Submit">Save
        <i class="material-icons right">done</i>
      </button>
    </div>
  </form>
</div>
<div class="section">
</div>


<div class="section">
</div>

<div class="section">
</div>
<jsp:include page="modules/gnome.jsp" />
<jsp:include page="modules/bestsellers.jsp" />
<jsp:include page="modules/footer.jsp" />

<script type="text/javascript">
  $(document).ready(function() {
    $('select').material_select();

    $('ul.tabs').tabs();


  });

  function changeTab(i){
    $('ul.tabs').tabs('select_tab', i);
  }
</script>

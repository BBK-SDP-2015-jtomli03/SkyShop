<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="modules/header.jsp" />

<jsp:include page="modules/remote.jsp" />

<div class="section">
</div>
<div class="row">
  <div class="col s12 m7 offset-l3 l6">
    <h3 class="header blue-grey-text">Log In</h3>
    <hr>
    <br style="clear:both;" />
    <div class="row">
      <form class="col s12">
        <div class="input-field col s10">
          <i class="material-icons prefix">account_circle</i>
          <input id="user" type="text" class="validate">
          <label for="user">Username/Email</label>
        </div>
        <div class="input-field col s10">
          <i class="material-icons prefix">lock</i>
          <input id="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
        <br style="clear:both;" />
        <br style="clear:both;" />
        <br style="clear:both;" />
        <button class="btn waves-effect waves-light" type="submit" name="action">Log In
          <i class="material-icons right">send</i>
        </button>
        <button class="btn waves-effect waves-light red" type="submit" name="action">Having Trouble?
        </button>
        <a class="btn waves-effect waves-light red right" href="/account">Sign Up</a>
      </form>
    </div>
  </div>
  <div class="col s12 m5 l4 offset-l1 z-depth-2 blue-grey lighten-3">

  </div>

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
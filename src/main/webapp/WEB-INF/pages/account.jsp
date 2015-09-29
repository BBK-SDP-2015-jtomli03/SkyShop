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
  <form:form class="col m12"  method="POST" action="/customer/new" commandName="command">
    <table>
      <tr>
        <td><form:label path="firstName">Name</form:label></td>
        <td><form:input path="firstName" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Submit"/>
        </td>
      </tr>
    </table>
  </form:form>
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
        console.log(i);
        $('ul.tabs').tabs('select_tab', i);
    }
</script>
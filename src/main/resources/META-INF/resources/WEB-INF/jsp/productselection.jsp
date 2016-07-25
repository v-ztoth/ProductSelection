<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.three_column {
    -webkit-column-count: 3; /* Chrome, Safari, Opera */
    -moz-column-count: 3; /* Firefox */
    column-count: 3;
}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
      $('input:checkbox').change(function ()
      {
          var checkedValues = $('input:checkbox:checked').map(function() {
              var id = this.id;
              var text = $("label[for='" + id + "']").text();
              return text
          }).get();
          $("#basket").val(checkedValues.join("\n"));
      });
     });
</script>

<body>
<form:form method="POST" commandName="productSelectorForm" class="three_column" id="form">

    <div id="sportChannels">
        <h2>Sports</h2>
        <form:checkboxes path="selectedSportChannelIds" items="${sportChannels}"
            itemLabel="productName" itemValue="id" delimiter="</br>"
        />
    </div>
    </br>
    <div id="newsChannels">
        <h2>News</h2>
        <form:checkboxes path="selectedNewsChannelIds" items="${newsChannels}"
            itemLabel="productName" itemValue="id" delimiter="</br>"
            />
    </div>
    </br>
    <div>
        <h2>Basket</h2>
        <textarea id="basket" rows="4" cols="50">
        </textarea>
        </br>
        <input type="submit" name="submit" value="Checkout">
    </div>
</form:form>

</body>

</html>
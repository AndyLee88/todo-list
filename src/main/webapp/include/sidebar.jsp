<div class="container" style="height: 94vh;">
    <hr>
    <ul>
        <li><a href="/todo/list">/todo/list</a></li>
        <li><a href="/todo/page/1/10">/todo/page</a></li>
        <li><a href="#" class="noti">/todo/noti</a></li>
    </ul>
    <hr>
    <ul>
        <li><a href="#" class="noti">/todo/rank</a></li>
        <li><a href="#" class="noti">/todo/total</a></li>
        <li><a href="#" class="noti">/todo/views</a></li>
    </ul>
    <hr>
    
</div>
<script>
var notiElements = document.querySelectorAll(".noti");

for (var i = 0; i < notiElements.length; i++) {
  notiElements[i].addEventListener("click", function(event){
    event.preventDefault();
    alert("In development!");
  });
}
</script>
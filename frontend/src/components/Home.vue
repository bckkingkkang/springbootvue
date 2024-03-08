<script>
import list from "@components/board/List.vue";
import Gallery from "@components/Gallery.vue";

export default {
  components : {
    list,
    Gallery
  }
}
</script>

<template>
  <h1>HOME</h1>
  <hr>

  <div>
    <Gallery></Gallery>
  </div>
  <div>
    <list></list>
  </div>

</template>

<style>


</style>
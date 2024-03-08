<script>
import Header from "@components/templates/Header.vue";
import Footer from "@components/templates/Footer.vue";
import Side from "@components/templates/Side.vue";

export default {
  name : 'Templates',
  components : {
    Header,
    Footer,
    Side,
  }
}

</script>

<template>
  <Header></Header>
  <div class="container">
    <Side></Side>
    <div class="contents">
      <router-view></router-view>
    </div>
  </div>
  <Footer></Footer>
</template>

<style scoped>

</style>
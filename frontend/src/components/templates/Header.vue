<script>
export default {
  name : 'Header'
}
</script>

<template>

  <header>
    <section class="hbody">
      <article class="nav">
        <div class="title"><router-link to="/">HOME</router-link></div>
        <ul id="menu">
          <li></li>
          <li><router-link to="/board/list">BOARD</router-link></li>
          <li><router-link to="/login">LOGIN</router-link></li>
        </ul>
        <i class="fab fa-twitter-square"></i>
        <i class="fas fa-bars"></i>
      </article>
    </section>
  </header>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

a {
  text-decoration: none;
}

li {
  list-style-type: none;
}

.hbody {
  background-color: black;
  width: 100%;
  height: 100px;
}

.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px 50px;
  color: white;
}

.title {
  font-size: 2em;
}

.title > a {
  color: white;
}
@media screen and (min-width: 625px) {

  #menu {
    display: flex;
  }

  #menu > li {
    padding: 20px 30px;
    font-size: 20px;
  }

  li > a {
    color: white;
  }

  .fab {
    font-size: 35px;
    color: #1DA1F2;
  }

  .fas {
    display: none;
  }
}
@media screen and (max-width: 625px) {

  .nav {
    padding: 30px 40px;
  }

  #menu {
    display: none;
  }

  .fab {
    display : none;
  }

  .fas {
    font-size: 2em;
  }
}
</style>
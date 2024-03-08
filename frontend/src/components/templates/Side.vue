<template>
  <div class="side">
    <h3>Sidebar</h3>
    <div id="menu">
      <router-link to="/board/list">전체 게시판</router-link>
    </div>
    <div>
      <router-link to="/board/write">게시글 등록</router-link>
    </div>

  </div>
</template>

<script>
export default {
  name : 'Side'
}

</script>

<style>
</style>

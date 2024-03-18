<template>
  <div>
    <form action="" @submit.prevent>
      <div>
        <label for="userid">아이디 : </label>
        <input type="text" id="userid" v-model="userid">
      </div>
      <div>
        <label for="password">비밀번호 : </label>
        <input type="text" id="password" v-model="password">
      </div>
      <button v-on:click="isLogin">로그인</button>
      <button><router-link to="/Signup">회원가입</router-link></button>
    </form>

  </div>
</template>

<script>
import axios from 'axios';
import router from "@/router/index.js"
import { ref } from 'vue';

const userid = ref('');
const password = ref('');

export default {
  data() {
    return {
      userid : '',
      password : ''
    }
  },
  methods : {
    isLogin() {
      if(this.userid == '') {
        alert('ID를 입력하세요');
        return;
      }
      if(this.password == '') {
        alert("PASSWORD를 입력하세요");
        return;
      }

      alert('로그인되었습니다.');
    },

  }
}


</script>

<style scoped>

</style>
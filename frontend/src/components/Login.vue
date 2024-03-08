<template>
  <div>
    <form action="" @submit.prevent>
      <div>
        <label for="userId">아이디 : </label>
        <input type="text" id="userId" v-model="userid">
      </div>
      <div>
        <label for="password">비밀번호 : </label>
        <input type="text" id="password" v-model="password">
      </div>
      <button v-on:click="login">로그인</button>
    </form>

  </div>
</template>

<script setup>
import axios from 'axios';
import router from "@/router/index.js"
import { ref } from 'vue';

const userid = ref('');
const password = ref('');

function login() {
  const response = axios.post(`/api/member/loginCheck_ajax`, {
    userid : userid.value,
    password : password.value
  }).then(response => {
        console.log(response)
      });
}


</script>

<style scoped>

</style>
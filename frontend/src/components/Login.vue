<template>
  <div>
    <form action="" @submit.prevent="goLogin">
      <div>
        <label for="userid">아이디 : </label>
        <input type="text" id="userid" v-model="userid" placeholder="아이디를 입력하세요">
      </div>
      <div>
        <label for="password">비밀번호 : </label>
        <input type="text" id="password" v-model="password" placeholder="비밀번호를 입력하세요">
      </div>
      <button>로그인</button>
      <button><router-link to="/Signup">회원가입</router-link></button>
    </form>

  </div>
</template>

<script>
import axios from 'axios';
import router from "@/router/index.js"
import {mapActions, mapGetters} from "vuex";

export default {
  data() {
    return {
      userid : '',
      password : ''
    }
  },

  methods : {
    /* action.js > login 함수 */
    ...mapActions(['login']),

    async goLogin() {
      if(this.userid == '') {
        alert('ID를 입력하세요');
        return;
      }
      if(this.password == '') {
        alert('Password를 입력하세요');
        return;
      }

      /* 로그인 API 호출 */
      try {
        let loginResult = await this.login({userid : this.userid, password : this.password})
        if (loginResult) {
          alert('로그인 결과 : ' + loginResult);
        }
      } catch (err) {
        if(err.message.indexOf('Network Error') > -1 ) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요');
        } else {
          alert('로그인 정보를 확인할 수 없습니다.');
        }
      }
    }
  },

  computed : {
    ...mapGetters({
      errorState : 'getErrorState'
    })
  }
}

</script>

<style scoped>

</style>
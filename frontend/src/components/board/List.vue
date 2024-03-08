<template>
  <h1>BOARD LIST</h1>
  <hr>
    <table class="table">
      <thead>
        <tr>
          <th>No</th>
          <th>제목</th>
          <th>작성자</th>
          <th>등록일시</th>
          <th>수정일시</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, seq) in list" :key="seq">
          <td>{{ row.seq }}</td>
          <td><a v-on:click="detailView(`${row.seq}`)">{{ row.title }}</a></td>
          <td>{{ row.author }}</td>
          <td>{{ row.create_dt }}</td>
          <td>{{ row.update_dt }}</td>
      </tr>
      </tbody>
    </table>

  <hr>
  <div>
    <div class="write_btn">
      <button type="button" @click="writeBoard"><router-link to="/board/write">등록</router-link></button>
    </div>
  </div>

</template>

<script>
import axios from "axios";
export default {
  name : 'list',

  data() {
    return {
      requestBody: {},
      list: {},
    }
  },
  mounted() {
    this.getBoardList();
  },
  methods : {
    getBoardList() {
      this.requestBody = {
        keyword : this.keyword,
        page : this.page,
        size : this.size
      }
      this.$axios.get(this.$serverUrl + "/board/list", {
        params : this.requestBody,
        headers : {}
      }).then((res) => {
        this.list = res.data
      })
    },
    detailView(seq) {
      this.requestBody.seq = seq

      this.$router.push({
        path : './Detail',
        query : this.requestBody
      })



    },
    writeBoard() {
      this.$router.push({
        path : './Write'
      })
    },
    fnPage(n) {
      if(this.page !== n) {
        this.page = n
        this.getBoardList()
      }
    }
  }

}

</script>

<style>

table {
  //border-collapse: collapse;
  width: fit-content;
  margin: 1rem auto;
  border: 1px solid #ddd;
  background-color: white;
}
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  text-align: center;
}

th {
  background-color: #1b1b1b;
  color: #ddd;
}

/* 테이블 올렸을 때 */
tbody tr:hover {
  background-color: #d3d3d3;
  opacity: 0.9;
}

/* 테이블 비율 */
th:nth-child(1),
td:nth-child(1) {
  width: 4%;
}

th:nth-child(2),
td:nth-child(2) {
  width: 24%;
  cursor: pointer;
}

th:nth-child(3),
td:nth-child(3) {
  width: 24%;
}
th:nth-child(4),
td:nth-child(4) {
  width: 24%;
}
th:nth-child(5),
td:nth-child(5) {
  width: 24%;
}
</style>
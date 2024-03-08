<template>
  <h1>BOARD DETAIL</h1>
  <hr>
  <div>
    <h3>[ {{ title }} ]</h3>
    <hr>
    <div>
      작성자 : <strong>{{ author }}</strong>
    </div>
    <hr>

    <div>
      작성일 : <strong>{{ create_dt }} </strong>
    </div>
    <div>
      {{  update_dt != null ? `수정일 : ` + update_dt : ''}}
    </div>
    <hr>
    <div>
      <span>{{ contents }}</span>
    </div>
    <hr>
  </div>
  <div>
    <button type="button" @click="updateBoard">수정</button>
    <button type="button" @click="deleteBoard" id="deleteBtn">삭제</button>
    <button type="button" @click="goList" id="listBtn">목록</button>
  </div>

</template>

<script>

export default {
  data() {
    return {
      requestBody : this.$route.query,
      seq : this.$route.query.seq,

      title : '',
      author : '',
      contents : '',
      create_dt : ''
    }
  },
  mounted() {
    this.GetBoardDetail()
  },
  methods : {
    GetBoardDetail() {
      this.$axios.get(this.$serverUrl + '/board/' + this.seq, {
        params : this.requestBody
      }).then((res) => {
        this.title = res.data.title
        this.author = res.data.author
        this.contents = res.data.contents
        this.create_dt = res.data.create_dt
        this.update_dt = res.data.update_dt
        this.status = res.data.status
      })
    },
    updateBoard() {
      this.$router.push({
        path : './Write',
        query : this.requestBody
      })
    },
    deleteBoard() {
      if (confirm('삭제하시겠습니까?')) {
        // this.$router.push({
        //   path: './List',
        //   query: this.requestBody
        // })

        let apiUrl = this.$serverUrl + '/board/delete'
        this.form = {
          "seq" : this.seq,
          "title" : this.title,
          "author" : this.author,
          "contents" : this.contents,
          "create_dt" : this.create_dt,
          "update_dt" : this.update_dt,
          "status" : "Y"
        }
        this.$axios.patch(apiUrl, this.form)
            .then((res)=> {
              alert('글이 삭제되었습니다.')
              this.goList(res.data)
            })

      }
    },
    goList() {
      delete this.requestBody.seq
      this.$router.push({
        path : './List',
        query : this.requestBody
      })
    }

  }
}


</script>



<style scoped>

</style>
<template>
  <div class="mymusic">
    <h1>这里是我加入的音乐</h1>

    <table>
      <tr>
        <th>序号</th>
        <th>歌名</th>
        <th>歌手</th>
        <th>入库时间</th>
        <th>播放</th>
      </tr>
      <tr v-for="(item, index) in tableData" :key="index">

        <td>{{index+1}}</td>
        <td>{{item.name}}</td>
        <td>{{item.singer}}</td>
        <td>{{item.time}}</td>
        <td><img src="../assets/icons/play.png" @click="play(item)" alt=""></td>
      </tr>
    </table>
    <button class="bbtn" @click="getData">重 新 获 取 数 据</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      tableData: [
        {
          time: "",
          name: "",
          singer: "",
        },
      ],
    };
  },
  created(){
    this.getData()
  },

  methods: {
    getData() {
      var that = this;
      axios({
        url:
          "http://localhost:8088/vue%E5%AE%9E%E8%AE%AD%E5%90%8E%E5%8F%B0/load",
        method: "get",
        params: {
          username: that.$store.state.userinfo.username,
        },
      }).then((res) => {
        console.log(res);
        this.tableData = res.data;
      });
    },
    play(item){
       this.$parent.musicdata = {
          url: item.musicurl,
          name: item.name,
          artist: item.singer,
        };
    }
  },
};
</script>

<style scope>
.mymusic .bbtn{
  height: 50px;
  font-size: 18px;
  width: 200px;
  border-radius: 15px;
  background-color: bisque;
}
.mymusic table{
  border: 1px;
  text-align: center;
  margin: auto;
  margin-top: 50px;
  font-size: 18px;
  margin-bottom: 30px;
}
.mymusic td{
  margin: 20px;
  width: 150px;
}
</style>
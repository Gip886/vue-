<template>
  <div class="songs-container">
    <el-backtop></el-backtop>

    <div class="tab-bar">
      <span class="item" @click="tag = '0'" :class="{ active: tag == '0' }"
        >全部</span
      >
      <span class="item" @click="tag = '7'" :class="{ active: tag == '7' }">
        华语</span
      >
      <span class="item" @click="tag = '96'" :class="{ active: tag == '96' }"
        >欧美</span
      >
      <span class="item" @click="tag = '8'" :class="{ active: tag == '8' }"
        >日本</span
      >
      <span class="item" @click="tag = '16'" :class="{ active: tag == '16' }"
        >韩国</span
      >
    </div>
    <!-- 底部的table -->
    <table class="el-table song-table">
      <thead>
        <th></th>
        <th></th>
        <th>音乐标题</th>
        <th>歌手</th>
        <th>专辑</th>
        <th>时长</th>
      </thead>
      <tbody>
        <tr class="song-row" v-for="(item, index) in lists" :key="index">
          <td clas class="index">{{ index + 1 }}</td>
          <td>
            <div class="img-wrap">
              <!-- <img :src="item.album.picUrl" alt="" /> -->
              <!-- 慵懒加载的方式 -->
              <el-image :src="item.album.picUrl" lazy></el-image>
              <img
                @click="play(item)"
                class="icon-play"
                src="../assets/icons/play.png"
                alt=""
              />
            </div>
          </td>
          <td>
            <div class="song-wrap">
              <div class="name-wrap">
                <span>{{ item.name }}</span>
                <span class="iconfont icon-mv"></span>
              </div>
              <span>{{ item.album.artists[0].name }}</span>
            </div>
          </td>
          <td>{{ item.artists[0].name }}</td>
          <td>{{ item.album.name }}</td>
          <td>{{ item.hMusic.playTime | time }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      lists: [],
      //分类
      tag: "0",
    };
  },
  watch: {
    tag: function () {
      this.getList();
    },
  },
  methods: {
    getList() {
      axios({
        url: "https://autumnfish.cn/top/song",
        method: "get",
        params: {
          type: this.tag,
        },
      }).then((res) => {
        console.log(res);
        this.lists = res.data.data;
      });
    },
    play(item) {
      // alert(id);
      axios({
        url: "https://autumnfish.cn/song/url",
        method: "get",
        params: {
          id: item.id,
        },
      }).then((res) => {
        // console.log(res);
        let url = res.data.data[0].url;

        this.$parent.musicdata = {
          url: url,
          name: item.name,
          artist: item.album.artists[0].name,
          cover: item.album.picUrl,
        };
      });
    },
  },
  created() {
    this.getList();
  },
  filters: {
    time(value) {
      //过滤音乐时长数据
      if (!value) return "";
      let min = parseInt(value / 1000 / 60);
      if (min < 10) {
        min = "0" + min;
      }
      let second = parseInt((value / 1000) % 60);
      if (second < 10) {
        second = "0" + second;
      }
      value = `${min}分${second}秒`;
      return value;
    },
  },
};
</script>

<style scope>
.songs-container .tab-bar {
  display: flex;
  justify-content: flex-end;
}

.songs-container .tab-bar .item {
  font-size: 15px;
  color: gray;
  margin-right: 20px;
  cursor: pointer;
}

.songs-container .tab-bar .item.active {
  color: #dd6d60;
}
.songs-container .song-table {
  font-size: 15px;
}
.songs-container .song-table .index {
  text-align: center;
  font-size: 18px;
}
.songs-container .song-table .song-row:hover {
  background: rgba(212, 212, 212, 0.8);
}

.songs-container .song-table .song-row:hover .icon-play {
  opacity: 1;
}
.songs-container .song-table .song-wrap > span {
  margin-top: 20px;
  display: inline-block;
  color: #bebebe;
}

.songs-container .song-table .song-wrap .icon-mv {
  padding-left: 5px;
  color: #dd6d60;
}

.songs-container .song-table .img-wrap {
  position: relative;
  width: 70px;
  height: 70px;
  cursor: pointer;
}

.songs-container .song-table .img-wrap img {
  width: 70px;
  height: 70px;
  border-radius: 5px;
}

.songs-container .song-table .img-wrap .icon-play {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 25px;
  height: 25px;
  color: #dd6d60;
  font-size: 12px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(255, 255, 255, 0.8);
  opacity: 0;
  transition: all 0.5s;
}

.songs-container .song-table .img-wrap .icon-play::before {
  transform: translateX(1px);
}
</style>
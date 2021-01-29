<template>
  <div class="news">
    <!-- <h3 class="title">最新音乐</h3> -->
    <div class="items">
      <div class="item" v-for="(item, index) in songsList" :key="index">
        <div class="img-wrap" @click="bofang(item)">
          <img :src="item.picUrl" alt="" />
          <img class="iconfont" src="../assets/icons/play.png" alt="">
        </div>
        <div class="song-wrap">
          <div class="song-name">{{ item.name }}</div>
          <div class="singer">{{ item.song.artists[0].name }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      songsList: [],
    };
  },
  methods: {
     randomColor() {
      return `#${((Math.random() * 0xffffff) << 0).toString(16)}`;
    },
    bofang(item) {
      //   console.log(id);
      axios({
        url: "https://autumnfish.cn/song/url",
        method: "get",
        params: {
          id: item.id,
        },
      }).then((res) => {
        console.log(res);
        let url = res.data.data[0].url;
        //  console.log(this.$AudioPlay.musicdata)
        // console.log(this.$parent.$parent.musicdata)
      
        
        this.$parent.$parent.musicdata = {
            url: url,
            name: item.name,
            artist: item.song.artists[0].name,
            cover: item.picUrl,
            theme:this.randomColor()
        //   name: "东西（Cover：林俊呈）",
        //   artist: "纳豆",
        //   url: "https://cdn.moefe.org/music/mp3/thing.mp3",
        //   cover: 'https://p1.music.126.net/5zs7IvmLv7KahY3BFzUmrg==/109951163635241613.jpg?param=300y300', // prettier-ignore
        //   lrc: "https://cdn.moefe.org/music/lrc/thing.lrc",
        };
    //   this.$parent.$parent.$refs.aplayer.play();
    // console.log(event.path[1].childNodes[0])
    // console.log(event)

      });
    },
  },
  created() {
    axios({
      url: "https://autumnfish.cn/personalized/newsong",
      method: "get",
    }).then((res) => {
      console.log(res);
      this.songsList = res.data.result;
    });
  },
};
</script>

<style scope>
.news {
  margin-bottom: 40px;
  width: 70%;
  margin: auto;
}

.news .items {
  height: 500px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  padding-left: 15px;

  /* flex-direction: row;
  flex-wrap: wrap;
  justify-content: center; */
}

.news .items .item {
  height: 100px;
  width: 50%;
  display: flex;
  align-items: center;
}

.news .items .item:hover {
  background-color: #f5f5f5;
}

.news .items .item .index {
  margin-right: 15px;
  font-size: 15px;
}

.news .items .item .img-wrap {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

.news .items .item .img-wrap img {
  width: 80px;
  height: 80px;
  border-radius: 15px;
}

.news .items .item .img-wrap .iconfont {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 30px;
  height: 30px;
  color: #dd6d60;
  text-align: center;
  line-height: 30px;
  border-radius: 50%;
  font-size: 14px;
  background: rgba(255, 255, 255, 0.8);
  opacity: 0;
  transition: all 0.5s ease-in-out;
}

.news .items .item .img-wrap .iconfont::before {
  transform: translateX(3px);
}

.news .items .item .img-wrap:hover .iconfont {
  opacity: 1;
}

.news .items .item .song-wrap {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 100%;
  padding: 10px;
  font-size: 16px;
}

.news .items .item .song-wrap .singer {
  font-size: 14px;
  color: gray;
  text-align: left;
}

</style>
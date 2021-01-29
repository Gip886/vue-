<template>
  <div class="result-container">
    <el-backtop></el-backtop>
    <div class="title-wrap">
      <h2 class="title">{{ $route.query.keywords }}</h2>
      <span class="sub-title">找到{{ count }}个结果</span>
    </div>
    <el-tabs v-model="activeIndex">
      <el-tab-pane label="歌曲" name="songs">
        <table class="el-table">
          <thead>
            <th></th>
            <th></th>
            <th></th>
            <th>音乐标题</th>
            <th>歌手</th>
            <th>专辑</th>
            <th>时长</th>
          </thead>
          <tbody>
            <tr
              class="el-table__row"
              v-for="(item, index) in songList"
              :key="index"
            >
              <td class="index">{{ index + 1 }}</td>
              <td class="bofang" @click="play(item)">
                <img src="../assets/icons/播放.png" alt="" />
              </td>
              <td>
                <img
                  class="love"
                  src="../assets/icons/爱心.png"
                  alt=""
                  @click="addsongs(item)"
                />
              </td>
              <td>
                <div class="song-wrap">
                  <div class="name-wrap">
                    <span>{{ item.name }}</span>
                    <span v-if="item.mvid != 0" class="iconfont icon-mv"
                      ><img src="../assets/icons/mv.png" alt=""
                    /></span>
                  </div>
                  <span v-if="item.alias.length != 0">{{ item.alias[0] }}</span>
                </div>
              </td>
              <td>{{ item.artists[0].name }}</td>
              <td>{{ item.album.name }}</td>
              <td>{{ item.duration | time }}</td>
            </tr>
          </tbody>
        </table>
      </el-tab-pane>
      <!-- <el-tab-pane label="歌单" name="lists">
        <div class="items">
          <div class="item">
            <div class="img-wrap">
              <div class="num-wrap">
                播放量:
                <span class="num">66892</span>
              </div>
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
            </div>
            <p class="name">编辑推荐：一起探索这个未知的音乐罐头吧！</p>
          </div>
          <div class="item">
            <div class="img-wrap">
              <div class="num-wrap">
                播放量:
                <span class="num">66892</span>
              </div>
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
            </div>
            <p class="name">编辑推荐：一起探索这个未知的音乐罐头吧！</p>
          </div>
          <div class="item">
            <div class="img-wrap">
              <div class="num-wrap">
                播放量:
                <span class="num">66892</span>
              </div>
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
            </div>
            <p class="name">编辑推荐：一起探索这个未知的音乐罐头吧！</p>
          </div>
          <div class="item">
            <div class="img-wrap">
              <div class="num-wrap">
                播放量:
                <span class="num">66892</span>
              </div>
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
            </div>
            <p class="name">编辑推荐：一起探索这个未知的音乐罐头吧！</p>
          </div>
          <div class="item">
            <div class="img-wrap">
              <div class="num-wrap">
                播放量:
                <span class="num">66892</span>
              </div>
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
            </div>
            <p class="name">编辑推荐：一起探索这个未知的音乐罐头吧！</p>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="MV" name="mv">
        <div class="items mv">
          <div class="item">
            <div class="img-wrap">
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
              <div class="num-wrap">
                <div class="iconfont icon-play"></div>
                <div class="num">9912</div>
              </div>
              <span class="time">02:43</span>
            </div>
            <div class="info-wrap">
              <div class="name">HEYNA</div>
              <div class="singer">余恩</div>
            </div>
          </div>
          <div class="item">
            <div class="img-wrap">
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
              <div class="num-wrap">
                <div class="iconfont icon-play"></div>
                <div class="num">9912</div>
              </div>
              <span class="time">02:43</span>
            </div>
            <div class="info-wrap">
              <div class="name">HEYNA</div>
              <div class="singer">余恩</div>
            </div>
          </div>
          <div class="item">
            <div class="img-wrap">
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
              <div class="num-wrap">
                <div class="iconfont icon-play"></div>
                <div class="num">9912</div>
              </div>
              <span class="time">02:43</span>
            </div>
            <div class="info-wrap">
              <div class="name">HEYNA</div>
              <div class="singer">余恩</div>
            </div>
          </div>
          <div class="item">
            <div class="img-wrap">
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
              <div class="num-wrap">
                <div class="iconfont icon-play"></div>
                <div class="num">9912</div>
              </div>
              <span class="time">02:43</span>
            </div>
            <div class="info-wrap">
              <div class="name">HEYNA</div>
              <div class="singer">余恩</div>
            </div>
          </div>
          <div class="item">
            <div class="img-wrap">
              <img src="" alt="" />
              <span class="iconfont icon-play"></span>
              <div class="num-wrap">
                <div class="iconfont icon-play"></div>
                <div class="num">9912</div>
              </div>
              <span class="time">02:43</span>
            </div>
            <div class="info-wrap">
              <div class="name">HEYNA</div>
              <div class="singer">余恩</div>
            </div>
          </div>
        </div>
      </el-tab-pane> -->
    </el-tabs>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "result",
  data() {
    return {
      activeIndex: "songs",
      //单曲数据列表
      songList: [],
      //搜索结果总数
      count: 0,
    };
  },
  watch: {
    $route() {
      this.search();
    },
  },
  methods: {
    play(item) {
      // console.log(item)
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
          artist: item.artists[0].name,
          cover: item.album.artist.img1v1Url,
        };
      });
    },
    search() {
      axios({
        url: "https://autumnfish.cn/search",
        method: "get",
        params: {
          keywords: this.$route.query.keywords,
          type: 1,
        },
      }).then((res) => {
        // console.log(res)
        this.songList = res.data.result.songs;
        //保存总数
        this.count = res.data.result.songCount;
      });
    },
    //2021.1.5增加爱心歌曲
    addsongs(item) {
      if (this.$store.state.isLogin) {
        item.username = this.$store.state.userinfo[0];
        var that = this;

        axios({
          url: "https://autumnfish.cn/song/url",
          method: "get",
          params: {
            id: item.id,
          },
        }).then((res) => {
          // console.log(res);
          var url = res.data.data[0].url;
          // alert(url)

          axios({
            url:
              "http://localhost:8088/vue%E5%AE%9E%E8%AE%AD%E5%90%8E%E5%8F%B0/addData",
            method: "get",
            params: {
              id: item.id,
              name: item.name,
              url: url,
              singer: item.artists[0].name,
              coverUrl: item.album.artist.img1v1Url,
              username: that.$store.state.userinfo.username,
            },
          })
            .then((res) => {
              // console.log(item);
              // console.log(res);
              //这里把数据发回去后端，保存进数据库
              if (res.data.status == "true") {
                this.$message({
                  message: "添加成功",
                  type: "success",
                });
              }else{
                  this.$message.error("添加失败哦");
              }
            })
            .catch((err) => {
              alert(err);
            });
        });

      
      } else {
        this.$message.error("添加失败，请你先登录");
      }
    },
  },
  created() {
    this.search();
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

<style scope >
.result-container .title-wrap {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 15px;
}

.result-container .title-wrap .title {
  margin-right: 10px;
  font-size: 30px;
}

.result-container .title-wrap .sub-title {
  font-size: 15px;
  color: #bebebe;
}

.result-container .el-tabs__item {
  font-size: 18px;
}
.result-container .el-table .el-table__row .bofang {
  cursor: pointer;
}
.result-container .el-table .el-table__row .index {
  text-align: center;
  font-size: 16px;
}
.result-container .el-table .el-table__row:nth-child(2n) {
  background-color: #fafafa;
}
.result-container .el-table .el-table__row:hover {
  background-color: #f2cac9;
}
.result-container .el-table td,
.result-container .el-table th.is-leaf {
  border-bottom: none;
}

.result-container .items {
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
}

.result-container .items .item {
  width: 200px;
  cursor: pointer;
  margin-right: 20px;
  margin-bottom: 20px;
}

.result-container .items .item .img-wrap {
  width: 100%;
  position: relative;
}

.result-container .items .item .img-wrap > .icon-play {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 40px;
  height: 40px;
  color: #dd6d60;
  font-size: 20px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(255, 255, 255, 0.8);
  opacity: 0;
}

.result-container .items .item .img-wrap > .icon-play::before {
  transform: translateX(3px);
}

.result-container .items .item .img-wrap:hover > .icon-play {
  opacity: 1;
}

.result-container .items .item .img-wrap img {
  width: 100%;
  border-radius: 5px;
}

.result-container .items .item .img-wrap .num-wrap {
  position: absolute;
  color: white;
  top: 0;
  right: 0;
  display: flex;
  align-items: center;
  font-size: 15px;
  padding-right: 5px;
  padding-top: 2px;
}

.result-container .items .item .img-wrap .num-wrap .icon-play {
  font-size: 12px;
  display: flex;
  align-items: center;
  margin-right: 5px;
}

.result-container .items .item .img-wrap .time {
  position: absolute;
  bottom: 5px;
  right: 5px;
  color: white;
  font-size: 15px;
}

.result-container .items .item .name {
  font-size: 15px;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}

.result-container .items .item .singer {
  font-size: 14px;
  color: #c5c5c5;
}

.result-container .items.mv .item {
  width: 250px;
}
.love {
  cursor: pointer;
}
</style>

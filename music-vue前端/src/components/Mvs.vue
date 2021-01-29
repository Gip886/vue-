<template>
  <div class="mvs-container">
    <div class="filter-wrap">
      <div class="seciton-wrap">
        <span class="section-type">地区:</span>
        <ul class="tabs-wrap">
          <li class="tab">
            <span
              class="title"
              @click="area = '全部'"
              :class="{ active: area == '全部' }"
              >全部</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="area = '内地'"
              :class="{ active: area == '内地' }"
              >内地</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="area = '港台'"
              :class="{ active: area == '港台' }"
              >港台</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="area = '欧美'"
              :class="{ active: area == '欧美' }"
              >欧美</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="area = '日本'"
              :class="{ active: area == '日本' }"
              >日本</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="area = '韩国'"
              :class="{ active: area == '韩国' }"
              >韩国</span
            >
          </li>
        </ul>
      </div>
      <div class="type-wrap">
        <span class="type-type">类型:</span>
        <ul class="tabs-wrap">
          <li class="tab">
            <span
              class="title"
              @click="type = '全部'"
              :class="{ active: type == '全部' }"
              >全部</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="type = '官方版'"
              :class="{ active: type == '官方版' }"
              >官方版</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="type = '原声'"
              :class="{ active: type == '原声' }"
              >原声</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="type = '现场版'"
              :class="{ active: type == '现场版' }"
              >现场版</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="type = '网易出品'"
              :class="{ active: type == '网易出品' }"
              >网易出品</span
            >
          </li>
        </ul>
      </div>
      <div class="order-wrap">
        <span class="order-type">排序:</span>
        <ul class="tabs-wrap">
          <li class="tab">
            <span
              class="title"
              @click="order = '上升最快'"
              :class="{ active: order == '上升最快' }"
              >上升最快</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="order = '最热'"
              :class="{ active: order == '最热' }"
              >最热</span
            >
          </li>
          <li class="tab">
            <span
              class="title"
              @click="order = '最新'"
              :class="{ active: order == '最新' }"
              >最新</span
            >
          </li>
        </ul>
      </div>
    </div>
    <!-- mv容器 -->
    <!-- 推荐MV -->
    <div class="mvs">
      <div class="items">
        <div class="item" v-for="(item, index) in mvList" :key="index">
          <div class="img-wrap">
            <img :src="item.cover" alt="" />
            <div class="num-wrap">
              <div class="iconfont icon-play">
                <img src="../assets/icons/minPlay.png" alt="" />
              </div>
              <div class="num">{{ item.playCount | count }}</div>
            </div>
          </div>
          <div class="info-wrap">
            <div class="name">{{ item.name }}</div>
            <div class="singer">{{ item.artistName }}</div>
          </div>
        </div>
      </div>
      <!-- 分页器 -->
      <el-pagination
        @current-change="handleCurrentChange"
        background
        layout="prev, pager, next"
        :total="total"
        :current-page="page"
        :page-size="5"
        :limit="limit"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      //总条数
      total: 20,
      //页码
      page: 1,
      //页容量
      limit: 8,
      //地区
      area: "全部",
      //类型
      type: "全部",
      //排序
      order: "上升最快",
      //获取的mv列表
      mvList: [],
    };
  },
  watch: {
    area() {
      //返回第一页
      this.page = 1;
      this.getMv();
    },
    type() {
      //返回第一页
      this.page = 1;
      this.getMv();
    },
    order() {
      //返回第一页
      this.page = 1;
      this.getMv();
    },
  },
  created() {
    this.getMv();
  },
  methods: {
    getMv() {
      axios({
        url: "https://autumnfish.cn/mv/all",
        method: "get",
        params: {
          area: this.area,
          type: this.type,
          order: this.order,
          //数量
          limit: this.limit,
          //偏移值
          offset: (this.page - 1) * this.limit,
        },
      }).then((res) => {
        //   console.log(res);
        this.mvList = res.data.data;
        //保存总条数
        if (res.data.count) {
          this.total = res.data.count;
        }
      });
    },
    handleCurrentChange(val) {
      this.page = val;
      this.getMv();
    },
  },
  filters: {
    count(value) {
      if (value > 100000) {
        let result = parseInt(value / 10000) + "万";
        return result;
      }
      return value;
    },
  },
};
</script>

<style scope>
ul {
  list-style: none;
}
.mvs-container {
  padding-top: 20px;
}
.mvs-container {
  padding: 20px;
}
.mvs-container .filter-wrap > div {
  margin-bottom: 30px;
  vertical-align: baseline;
  display: flex;
  align-items: center;
}

.mvs-container .filter-wrap > div span {
  font-size: 14px;
  height: 100%;
}

.mvs-container .filter-wrap > div span.title {
  margin: 20px;
  color: gray;
  cursor: pointer;
  padding: 5px 20px;
}

.mvs-container .filter-wrap > div span.title.active {
  color: #dd6d60;
  background-color: #fcf6f5;
  border-radius: 20px;
}

.mvs-container .filter-wrap > div span.title::before {
  content: "", pos;
}

.mvs-container .filter-wrap > div ul {
  display: flex;
}

.mvs-container .filter-wrap > div ul li:not(:last-child) {
  border-right: 1px solid #f2f2f1;
}

.mvs-container .mvs .items {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.mvs-container .mvs .items .item {
  width: 250px;
  cursor: pointer;
  margin-right: 25px;
  margin-bottom: 30px;
}

.mvs-container .mvs .items .item .img-wrap {
  width: 100%;
  position: relative;
}

.mvs-container .mvs .items .item .img-wrap img {
  width: 100%;
  border-radius: 5px;
}

.mvs-container .mvs .items .item .img-wrap .num-wrap {
  position: absolute;
  color: white;
  top: 0;
  right: 0;
  display: flex;
  align-content: center;
  font-size: 15px;
  padding-right: 5px;
  padding-top: 2px;
}

.mvs-container .mvs .items .item .img-wrap .num-wrap .icon-play {
  font-size: 12px;
  display: flex;
  align-items: center;
  margin-right: 5px;
}

.mvs-container .mvs .items .item .info-wrap .name {
  font-size: 15px;
}

.mvs-container .mvs .items .item .info-wrap .singer {
  font-size: 14px;
  color: #c5c5c5;
}
.mvs-container .mvs .items .item .num-wrap .num {
  background-color: black;
}
</style>
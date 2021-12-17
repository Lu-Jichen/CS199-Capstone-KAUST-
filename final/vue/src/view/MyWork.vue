<template>
  <el-container style="height: 1200px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '2']">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-user"></i>User Info
          </template>
          <router-link :to="'/main'">
            <el-menu-item index="1-1">Personal Homepage</el-menu-item>
          </router-link>
          <router-link :to="'/myErrand'">
            <el-menu-item index="1-1">MyErrand</el-menu-item>
          </router-link>
          <router-link :to="'/myWork'">
            <el-menu-item index="1-1">MyWork</el-menu-item>
          </router-link>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>Menu
          </template>
          <router-link :to="'/errandList'">
            <el-menu-item index="2-1">Errand List</el-menu-item>
          </router-link>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
<!--          <el-dropdown-menu slot="dropdown">-->
<!--            <el-dropdown-item>view</el-dropdown-item>-->
<!--            <el-dropdown-item>create</el-dropdown-item>-->
<!--            <el-dropdown-item>delete</el-dropdown-item>-->
<!--          </el-dropdown-menu>-->
        </el-dropdown>
        <span>Operation</span>
      </el-header>
      <el-main>
        <el-table :data="tableData">
          <el-table-column prop="username" label="Creator" width="150"></el-table-column>
          <el-table-column prop="typeName" label="Errand Type" width="150"></el-table-column>
          <el-table-column prop="createTime" label="Create Time" width="230"></el-table-column>
          <el-table-column prop="price" label="Price" width="150"></el-table-column>
          <el-table-column prop="statusDes" label="Status" width="150"></el-table-column>
          <el-table-column fixed="right" label="Operation" width="180">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope)" type="text" size="small">view</el-button>
              <el-button @click="dropErrand(scope)" type="text" size="small">drop</el-button>
              <el-button @click="doneErrand(scope)" type="text" size="small">done</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination class="mpage"
                       background
                       layout="prev, pager, next"
                       :current-page=pageNum
                       :page-size=pageSize
                       @current-change=page
                       :total="total">
        </el-pagination>
      </el-main>
    </el-container>
  </el-container>
</template>
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}
.el-aside {
  color: #333;
}
</style>
<script>
import Cookies from 'js-cookie'
export default {
  name: 'UserIndex',
  data () {
    return {
      tableData: [],
      pageNum: 1,
      total: 0,
      pageSize: 5
    }
  },
  mounted () {
    this.page(Cookies.get('userId'))
  },
  methods: {
    page (userId) {
      const _this = this
      this.$axios.post('/errand/list/work', {
        userId: userId
      }).then((res) => {
        _this.tableData = res.data.data
        // _this.pageNum = res.data.code
        // _this.total = res.data.data.total
        // _this.pageSize = res.data.data.pageSize
      })
    },
    handleClick (scope) {
      if (scope.row.typeName === 'pet care') {
        this.$router.push({ name: 'Pet', params: { create: false, errandId: scope.row.errandId, typeName: scope.row.typeName, editable: false } })
      } else if (scope.row.typeName === 'delivery') {
        this.$router.push({ name: 'Delivery', params: { create: false, errandId: scope.row.errandId, typeName: scope.row.typeName, editable: false } })
      }
    },
    dropErrand (scope) {
      this.$axios.post('/errand/drop', {
        errandId: scope.row.errandId,
        userId: Cookies.get('userId')
      }).then((res) => {
      })
      this.$router.go(0)
    },
    doneErrand (scope) {
      this.$axios.post('/errand/done', {
        errandId: scope.row.errandId
      }).then((res) => {
      })
      this.$router.go(0)
    }
  }
}
</script>

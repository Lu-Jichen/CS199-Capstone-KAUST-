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
        <section class="p-10" style="float: left; margin-left: 10px">
          Errand Type:
          <el-select v-model="searchErrandType" @change="selectedChange1" placeholder="Selection" filterable :filter-method="dataFilter1">
            <el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </section>
        <section class="p-10" style="float:left; margin-left: 10px">
          Price Interval:
          <el-select v-model="searchPriceInterval" @change="selectedChange2" placeholder="Selection" filterable :filter-method="dataFilter2">
            <el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </section>
        <section class="p-10" style="float:left; margin-left: 10px">
          Status:
          <el-select v-model="searchStatus" @change="selectedChange3" placeholder="Selection" filterable :filter-method="dataFilter3">
            <el-option v-for="item in options3" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </section>
        <el-button @click="search()" >Search</el-button>
        <i class="el-icon-brush" style="margin-right: 15px" @click="clear()"></i>
<!--        <el-button @click="search()" style="float: right">Clear</el-button>-->
      </el-header>
      <el-main>
        <el-table :data="tableData" @sort-change="sortChange">
          <el-table-column prop="username" label="Creator" width="150" sortable="custom"></el-table-column>
          <el-table-column prop="typeName" label="Errand Type" width="150" sortable="custom"></el-table-column>
          <el-table-column prop="createTime" label="Create Time" width="230" sortable="custom"></el-table-column>
          <el-table-column prop="price" label="Price" width="150" sortable="custom"></el-table-column>
          <el-table-column prop="statusDes" label="Status" width="150" sortable="custom"></el-table-column>
          <el-table-column fixed="right" label="Operation" width="100">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope)" type="text" size="small">view</el-button>
              <el-button @click="selectErrand(scope)" type="text" size="small">Select</el-button>
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
      pageSize: 5,
      orderCol: '',
      order: '',
      searchErrandType: '',
      searchPriceInterval: '',
      searchStatus: '',
      options1: [{value: '1', label: 'pet care'}, {value: '2', label: 'delivery'}],
      optionsCopy1: [{value: '1', label: 'pet care'}, {value: '2', label: 'delivery'}],
      options2: [{value: '1', label: '0-10'}, {value: '2', label: '10-30'}, {value: '3', label: '30-50'}, {value: '4', label: '50-'}],
      optionsCopy2: [{value: '1', label: '0-10'}, {value: '2', label: '10-30'}, {value: '3', label: '30-50'}, {value: '4', label: '50+'}],
      options3: [{value: '1', label: 'Open'}, {value: '2', label: 'On'}, {value: '3', label: 'Finish'}, {value: '4', label: 'Close'}],
      optionsCopy3: [{value: '1', label: 'Open'}, {value: '2', label: 'On'}, {value: '3', label: 'Finish'}, {value: '4', label: 'Close'}]
    }
  },
  mounted () {
    this.page(1)
  },
  methods: {
    page (pageNum) {
      // const _this = this
      this.$axios.post('/errand/list', {
        orderCol: this.orderCol,
        order: this.order,
        searchErrandType: this.searchErrandType,
        searchPriceInterval: this.searchPriceInterval,
        searchStatus: this.searchStatus
      }).then((res) => {
        this.tableData = res.data.data
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
    selectErrand (scope) {
      // eslint-disable-next-line no-unused-expressions
      this.$axios.post('/errand/receive', {
        userId: Cookies.get('userId'),
        errandId: scope.row.errandId
        // eslint-disable-next-line no-sequences
      })
      this.$router.go(0)
    },
    sortChange (column) {
      if (column.prop == null) {
        this.orderCol = ''
        this.order = ''
      } else {
        this.orderCol = column.prop
        if (column.order === 'ascending') {
          this.order = 'asc'
        } else {
          this.order = 'desc'
        }
      }
      // eslint-disable-next-line no-undef
      this.$axios.post('/errand/list', {
        orderCol: this.orderCol,
        order: this.order,
        searchErrandType: this.searchErrandType,
        searchPriceInterval: this.searchPriceInterval,
        searchStatus: this.searchStatus
      }).then((res) => {
        this.tableData = res.data.data
      })
    },
    dataFilter1 (val) {
      this.searchErrandType = val
      if (val) {
        this.options1 = this.optionsCopy1.filter((item) => {
          if (!!~item.label.indexOf(val) || !!~item.label.toUpperCase().indexOf(val.toUpperCase())) {
            return true
          }
        })
      } else {
        this.options1 = this.optionsCopy1
      }
    },
    dataFilter2 (val) {
      this.searchPriceInterval = val
      if (val) {
        this.options2 = this.optionsCopy2.filter((item) => {
          if (!!~item.label.indexOf(val) || !!~item.label.toUpperCase().indexOf(val.toUpperCase())) {
            return true
          }
        })
      } else {
        this.options2 = this.optionsCopy2
      }
    },
    dataFilter3 (val) {
      this.searchStatus = val
      if (val) {
        this.options3 = this.optionsCopy3.filter((item) => {
          if (!!~item.label.indexOf(val) || !!~item.label.toUpperCase().indexOf(val.toUpperCase())) {
            return true
          }
        })
      } else {
        this.options3 = this.optionsCopy3
      }
    },
    selectedChange1 (vId) {
      // eslint-disable-next-line no-unused-vars
      let obj = {}
      obj = this.options1.find((item) => {
        return item.value === vId
      })
      this.searchErrandType = obj.label
      // alert(obj.label)
    },
    selectedChange2 (vId) {
      // eslint-disable-next-line no-unused-vars
      let obj = {}
      obj = this.options2.find((item) => {
        return item.value === vId
      })
      this.searchPriceInterval = obj.label
      // alert(obj.label)
    },
    selectedChange3 (vId) {
      // eslint-disable-next-line no-unused-vars
      let obj = {}
      obj = this.options3.find((item) => {
        return item.value === vId
      })
      this.searchStatus = obj.label
      // alert(obj.label)
    },
    search () {
      this.$axios.post('/errand/list', {
        orderCol: this.orderCol,
        order: this.order,
        searchErrandType: this.searchErrandType,
        searchPriceInterval: this.searchPriceInterval,
        searchStatus: this.searchStatus
      }).then((res) => {
        this.tableData = res.data.data
        // _this.pageNum = res.data.code
        // _this.total = res.data.data.total
        // _this.pageSize = res.data.data.pageSize
      })
      // this.searchErrandType = ''
      // this.searchPriceInterval = ''
      // this.searchStatus = ''
    },
    clear () {
      this.searchErrandType = ''
      this.searchPriceInterval = ''
      this.searchStatus = ''
    }
  }
}
</script>

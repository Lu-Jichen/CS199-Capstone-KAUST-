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
      <el-main>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <div v-if="editable">
              <div v-if="!edit">
                <i style="margin-right: 15px" :class="'el-icon-edit'" @click="edit = !edit"></i>
              </div>
              <div v-else>
                <i style="margin-right: 15px" :class="'el-icon-check'" @click="edit = !edit; editUserInfo() ">
                </i>
              </div>
            </div>
            <!--            <div>-->
            <!--              <i style="float: left" :class="'el-icon-back'" @click="back"></i>-->
            <!--            </div>-->
          </el-dropdown>
          <span>Operation</span>
        </el-header>
        <el-card align="left">
          Creator Name:  {{deliveryInfo['username']}}
        </el-card>

        <el-card align="left" v-show="!edit">
          Create Time:  {{deliveryInfo['createTime']}}
        </el-card>
        <el-card v-show="edit">
          Create Time:  {{deliveryInfo['createTime']}}
        </el-card>

        <el-card align="left" v-show="!edit">
          Current Status:  {{deliveryInfo['statusDes']}}
        </el-card>
        <el-card v-show="edit">
          Current Status:  {{deliveryInfo['statusDes']}}
        </el-card>

        <el-card align="left" v-show="!edit">
          Price:  {{deliveryInfo['price']}} $
        </el-card>
        <el-card v-show="edit">
          Price:
          <el-input  v-model="deliveryInfo.price">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          StartTime:  {{deliveryInfo['startTime']}}
        </el-card>
        <el-card v-show="edit">
          StartTime:
          <el-input  v-model="deliveryInfo.startTime">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          EndTime:  {{deliveryInfo['endTime']}}
        </el-card>
        <el-card v-show="edit">
          EndTime:
          <el-input  v-model="deliveryInfo.endTime">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Departure:  {{deliveryInfo['departure']}}
        </el-card>
        <el-card v-show="edit">
          Departure:
          <el-input  v-model="deliveryInfo.departure">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Destination:  {{deliveryInfo['destination']}}
        </el-card>
        <el-card v-show="edit">
          Destination:
          <el-input  v-model="deliveryInfo.destination">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Item Description:  {{deliveryInfo['itemDescription']}}
        </el-card>
        <el-card v-show="edit">
          Item Description:
          <el-input  v-model="deliveryInfo.itemDescription">
          </el-input>
        </el-card>
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
export function dateFormat (date) {
  // var date = new Date(time)
  var year = date.getFullYear()
  var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
  var day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
  var hours = date.getHours() < 10 ? '0' + date.getHours() : date.getHours()
  var minutes = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()
  var seconds = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()
  return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds
}

export default {
  name: 'UserIndex',
  data () {
    return {
      username: Cookies.get('username'),
      deliveryInfo: [],
      pageNum: 1,
      total: 0,
      pageSize: 5,
      edit: false,
      editable: false,
      description: 'Hello',
      create: false
    }
  },
  created () {
    if (this.$route.params.create === false) {
      this.page(this.$route.params.errandId, this.$route.params.typeName)
      this.editable = this.$route.params.editable
    } else if (this.$route.params.create === true) {
      this.edit = true
      this.editable = true
      this.create = true
      this.deliveryInfo['username'] = Cookies.get('username')
      this.deliveryInfo['statusDes'] = 'Open'
      this.deliveryInfo['createTime'] = dateFormat(new Date())
    }
  },
  methods: {
    page (errandId, typeName) {
      const _this = this
      this.$axios.post('/errand/typeDetail', {
        // eslint-disable-next-line no-undef
        errandId: errandId,
        typeName: typeName
      }).then((res) => {
        _this.deliveryInfo = res.data.data
        if (parseInt(res.data.data['userId']) === parseInt(Cookies.get('userId'))) {
          this.editable = true
        }
      })
    },
    handleClick (e, scope) {
      this.$router.push({ path: '/main', query: { id: scope.row.id } })
    },
    // eslint-disable-next-line vue/no-dupe-keys
    editUserInfo () {
      if (this.create === false) {
        this.$axios.post('/errand/delivery/update', {
          errandId: this.deliveryInfo.errandId,
          price: this.deliveryInfo.price,
          startTime: this.deliveryInfo.startTime,
          endTime: this.deliveryInfo.endTime,
          departure: this.deliveryInfo.departure,
          destination: this.deliveryInfo.destination,
          itemDescription: this.deliveryInfo.itemDescription
        }).then((res) => {
        })
      } else if (this.create === true) {
        this.$axios.post('/errand/delivery/insert', {
          userId: Cookies.get('userId'),
          errandId: this.deliveryInfo.errandId,
          price: this.deliveryInfo.price,
          startTime: this.deliveryInfo.startTime,
          endTime: this.deliveryInfo.endTime,
          departure: this.deliveryInfo.departure,
          destination: this.deliveryInfo.destination,
          itemDescription: this.deliveryInfo.itemDescription
        }).then((res) => {
        })
        this.$router.go(-1)
      }
    },
    back () {
      this.$router.go(-1)
    }
  }
}
</script>

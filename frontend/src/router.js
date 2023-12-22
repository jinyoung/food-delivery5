
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import UserOrderManagementOrderManager from "./components/listers/UserOrderManagementOrderCards"
import UserOrderManagementOrderDetail from "./components/listers/UserOrderManagementOrderDetail"

import RiderManagementRiderManager from "./components/listers/RiderManagementRiderCards"
import RiderManagementRiderDetail from "./components/listers/RiderManagementRiderDetail"

import StoreManagementMenuManager from "./components/listers/StoreManagementMenuCards"
import StoreManagementMenuDetail from "./components/listers/StoreManagementMenuDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/userOrderManagements/orders',
                name: 'UserOrderManagementOrderManager',
                component: UserOrderManagementOrderManager
            },
            {
                path: '/userOrderManagements/orders/:id',
                name: 'UserOrderManagementOrderDetail',
                component: UserOrderManagementOrderDetail
            },

            {
                path: '/riderManagements/riders',
                name: 'RiderManagementRiderManager',
                component: RiderManagementRiderManager
            },
            {
                path: '/riderManagements/riders/:id',
                name: 'RiderManagementRiderDetail',
                component: RiderManagementRiderDetail
            },

            {
                path: '/storeManagements/menus',
                name: 'StoreManagementMenuManager',
                component: StoreManagementMenuManager
            },
            {
                path: '/storeManagements/menus/:id',
                name: 'StoreManagementMenuDetail',
                component: StoreManagementMenuDetail
            },



    ]
})

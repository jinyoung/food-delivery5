
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FrontOrderManager from "./components/listers/FrontOrderCards"
import FrontOrderDetail from "./components/listers/FrontOrderDetail"

import StoreOrderManager from "./components/listers/StoreOrderCards"
import StoreOrderDetail from "./components/listers/StoreOrderDetail"

import RiderOrderManager from "./components/listers/RiderOrderCards"
import RiderOrderDetail from "./components/listers/RiderOrderDetail"

import CustomerOrderManager from "./components/listers/CustomerOrderCards"
import CustomerOrderDetail from "./components/listers/CustomerOrderDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/fronts/orders',
                name: 'FrontOrderManager',
                component: FrontOrderManager
            },
            {
                path: '/fronts/orders/:id',
                name: 'FrontOrderDetail',
                component: FrontOrderDetail
            },

            {
                path: '/stores/orders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/stores/orders/:id',
                name: 'StoreOrderDetail',
                component: StoreOrderDetail
            },

            {
                path: '/riders/orders',
                name: 'RiderOrderManager',
                component: RiderOrderManager
            },
            {
                path: '/riders/orders/:id',
                name: 'RiderOrderDetail',
                component: RiderOrderDetail
            },

            {
                path: '/customers/orders',
                name: 'CustomerOrderManager',
                component: CustomerOrderManager
            },
            {
                path: '/customers/orders/:id',
                name: 'CustomerOrderDetail',
                component: CustomerOrderDetail
            },



    ]
})

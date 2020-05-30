import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Text from '../views/Tekst.vue';
import Table from '../views/Table.vue';
import StaticTable from '../views/StaticTable.vue';
import DynamicTable from '../views/DynamicTable.vue';
import DynamicTableSimple from '../views/DynamicTableSimple.vue';
import DynamicTableData1k from '../views/DynamicTableData1k.vue';
import DynamicTableData10k from '../views/DynamicTableData10k.vue';
import DynamicTableData1m from '../views/DynamicTableData1m.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/text',
    name: 'Text',
    component: Text,
  },
  {
    path: '/table',
    name: 'Table',
    component: Table,
  },
  {
    path: '/static-table',
    name: 'StaticTable',
    component: StaticTable,
  },
  {
    path: '/dynamic-table',
    name: 'DynamicTable',
    component: DynamicTable,
  },
  {
    path: '/dynamic-table/simple',
    name: 'DynamicTableSimple',
    component: DynamicTableSimple,
  },
  {
    path: '/dynamic-table/data1k',
    name: 'DynamicTableData1k',
    component: DynamicTableData1k,
  },
  {
    path: '/dynamic-table/data10k',
    name: 'DynamicTableData10k',
    component: DynamicTableData10k,
  },
  {
    path: '/dynamic-table/data1m',
    name: 'DynamicTableData1m',
    component: DynamicTableData1m,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;

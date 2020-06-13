import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Text from '../views/Tekst.vue';
import Table from '../views/Table.vue';
import StaticTable from '../views/StaticTable.vue';
import DynamicTable from '../views/DynamicTable.vue';
import DynamicTableSimple from '../views/DynamicTableSimple.vue';
import DynamicTableData1k from '../views/DynamicTableData1k.vue';
import DynamicTableData3k from '../views/DynamicTableData3k.vue';
import DynamicTableData5k from '../views/DynamicTableData5k.vue';
import DynamicTableData10k from '../views/DynamicTableData10k.vue';
import DynamicTableData20k from '../views/DynamicTableData20k.vue';
import DynamicTableData50k from '../views/DynamicTableData50k.vue';
import DynamicTableData1m from '../views/DynamicTableData1m.vue';
import DynamicTableData3m from '../views/DynamicTableData3m.vue';
import DynamicTableData5m from '../views/DynamicTableData5m.vue';
import DynamicTableData10m from '../views/DynamicTableData10m.vue';

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
    path: '/dynamic-table/data3k',
    name: 'DynamicTableData3k',
    component: DynamicTableData3k,
  },
  {
    path: '/dynamic-table/data5k',
    name: 'DynamicTableData5k',
    component: DynamicTableData5k,
  },
  {
    path: '/dynamic-table/data10k',
    name: 'DynamicTableData10k',
    component: DynamicTableData10k,
  },
  {
    path: '/dynamic-table/data20k',
    name: 'DynamicTableData20k',
    component: DynamicTableData20k,
  },
  {
    path: '/dynamic-table/data50k',
    name: 'DynamicTableData50k',
    component: DynamicTableData50k,
  },
  {
    path: '/dynamic-table/data1m',
    name: 'DynamicTableData1m',
    component: DynamicTableData1m,
  },
  {
    path: '/dynamic-table/data3m',
    name: 'DynamicTableData3m',
    component: DynamicTableData3m,
  },
  {
    path: '/dynamic-table/data5m',
    name: 'DynamicTableData5m',
    component: DynamicTableData5m,
  },
  {
    path: '/dynamic-table/data10m',
    name: 'DynamicTableData10m',
    component: DynamicTableData10m,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;

<template>
  <div class="StaticTable">
    <table>
      <thead>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>email</th>
        <th>gender</th>
        <th>ip_address</th>
      </thead>
      <tbody>
        <tr v-for=" el in items" v-bind:key="el">
          <td>{{ el.id }}</td>
          <td>{{ el.Imie }}</td>
          <td>{{ el.Nazwisko }}</td>
          <td>{{ el.email }}</td>
          <td>{{ el.gender }}</td>
          <td>{{ el.ip_address }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import list from './json/jsonDataTable.json';

export default {
  data() {
    return {
      items: list,
    };
  },

  updated() {
    console.warn(`Stop:${Date.now()}`);
  },
  name: 'StaticTable',
};
</script>

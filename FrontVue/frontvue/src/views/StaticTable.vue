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
        {elementRender}
      </table>
    </div>
</template>

<script>
// import pliczek from '../assets/data/jsonDataTable.json';

export default {
  data() {
    return {
      elementRender: {},
      pl: {},
    };
  },
  // beforeCreate() {
  //   this.pl = pliczek.map((item) => (
  //     <tr key={item.id}>
  //       <td>{item.id}</td>
  //       <td>{item.Imie}</td>
  //       <td>{item.Nazwisko}</td>
  //       <td>{item.email}</td>
  //       <td>{item.gender}</td>
  //       <td>{item.ip_address}</td>
  //     </tr>
  //   ));
  // },

  // beforeMount() {
  //   this.elementRender = this.pl;
  // },

  updated() {
    console.warn(`Stop:${Date.now()}`);
  },
  methods: {
    async getText() {
      const res = await fetch('http://localhost:8080/simple');
      const data = await res.json();
      this.data = data;
    },
  },
  name: 'StaticTable',
};
</script>

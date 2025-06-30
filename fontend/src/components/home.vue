<template>
  <div>
    <!-- Header: tên + avatar người đăng nhập -->
    <header class="header">
      <div class="user-info">
        <span class="user-name">{{ use.name || use._id }}</span>
        <img v-if="use.avatar" :src="getImageUrl(use.avatar)" class="user-avatar" />
        <button @click="useLogout" class="btn btn-logout">Đăng xuất</button>
      </div>
    </header>

    <!-- Tiêu đề -->
    <h1 class="page-title">Danh sách người dùng</h1>

    <!-- Danh sách người dùng -->
    <ul class="user-list">
      <li v-for="u in user" :key="u._id" class="user-card">
        <div class="user-details">
          <strong>{{ u._id }}</strong> - {{ u.name }}
          <div v-if="u.avatar" class="avatar-wrapper">
            <img :src="getImageUrl(u.avatar)" class="avatar" />
          </div>
          <button @click="deleteUser(u._id)" class="btn btn-danger">Xoá</button>
        </div>
      </li>
    </ul>
  </div>
</template>


<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import router from '../router/index'

export default {
  setup() {
    const user = ref([]);
    const use = ref({}); // chỉ 1 user nên là object, không phải mảng

    const getImageUrl = (path) => {
      return 'http://localhost:8080' + path;
    };

    const deleteUser = async (id) => {
      const token = localStorage.getItem('token');
      if (!confirm('Bạn có chắc muốn xoá?')) return;

      try {
        await axios.delete(`http://localhost:8080/delete/${id}`, {
          headers: { Authorization: `Bearer ${token}` },
        });
        
        user.value = user.value.filter(u => u._id !== id); 
        alert('da xoa');
        router.push('/login');
      } catch (error) {
        console.error('Lỗi khi xoá:', error);
        alert('Xoá thất bại');
      }
    };

    const useLogout = async () => {
      const token = localStorage.getItem('token');
      if (!token) {
        alert('Bạn chưa đăng nhập');
        router.push('/login'); 
        return;
      }

      const confirmed = confirm('Bạn có chắc muốn đăng xuất?');
      if (!confirmed) return;

      try {
        await axios.post(
          'http://localhost:8080/logout',
          {},
          {
            headers: {
              Authorization: `Bearer ${token}`
            },
            withCredentials: true 
          }
        );

        localStorage.removeItem('token'); 
        alert('Đăng xuất thành công');
        router.push('/login'); 
      } catch (error) {
        console.error('Lỗi khi đăng xuất:', error);
        alert('Đăng xuất thất bại');
      }
    };


    const duy12 = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await axios.get('http://localhost:8080/duy123', {
          headers: { Authorization: `Bearer ${token}` },
        });
        if (res.data.status === 200) {
          user.value = res.data.user;
          use.value = res.data.use;
        } else {
          alert(res.data.error);
        }
      } catch (err) {
        console.error(err);
        alert('Không lấy được dữ liệu');
      }
    };

    onMounted(() => {
      duy12();
    });

    return {
      use,
      user,
      getImageUrl,
      deleteUser,
      useLogout,
    };
  },
};
</script>
<style scoped>
.header {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 16px 24px;
  background: #f9f9f9;
  border-bottom: 1px solid #ddd;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 16px;
}

.user-name {
  font-weight: 600;
  color: #333;
  font-size: 1.1rem;
}

.user-avatar {
  width: 42px;
  height: 42px;
  border-radius: 50%;
  object-fit: cover;
  border: 2px solid #667eea;
  box-shadow: 0 2px 6px rgba(102, 126, 234, 0.2);
}

.btn-logout {
  background: #6c757d;
  color: white;
  padding: 6px 12px;
  border-radius: 6px;
  border: none;
  cursor: pointer;
  transition: background 0.2s ease;
}

.btn-logout:hover {
  background: #5a6268;
}

.page-title {
  text-align: center;
  margin-top: 30px;
  font-size: 1.8rem;
  color: #444;
}

.user-list {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 20px;
  padding: 20px;
}

.user-card {
  background: #fff;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.avatar {
  width: 100%;
  max-width: 160px;
  border-radius: 8px;
  margin-top: 10px;
}

.btn-danger {
  background: #e74c3c;
  color: white;
  padding: 6px 12px;
  border-radius: 6px;
  border: none;
  margin-top: 10px;
  cursor: pointer;
  transition: background 0.2s ease;
}

.btn-danger:hover {
  background: #c0392b;
}
</style>

import { updateUser } from "../Fetches/updateUser";
import useCurrentUser from "../Fetches/GetCurrentUser";

function UserUpdateForm() {
  let user = useCurrentUser();
 //   let user = {name: "valaki", id: 1, password: "titok", description: "nemtdomcnjnvcwoa"}

  function update(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    user = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});
    updateUser(user);
    console.log(user);
  }

  return (
    <div>
      <form className="eventForm" onSubmit={update}>
        <div className="form">
          <h2>Update your Profile!</h2>

          <div className="id">
            <input type="hidden" name="id" defaultValue={user.id} />
          </div>

          <div className="name">
            <label htmlFor="name">Username</label>
            <input
              type="text"
              defaultValue={user ? user.name : null}
              name="name"
              id="name"
            />
          </div>

          <div className="password">
            <label htmlFor="password">Old Password</label>
            <input type="password"  />
            <label htmlFor="password">New Password</label>
            <input
              type="password"
              defaultValue={user ? user.password : null}
              name="password"
              id="password"
            />
          </div>

          <div className="description">
            <label htmlFor="description">Description</label>
            <input
              type="text"
              defaultValue={user ? user.description : null}
              name="description"
              id="description"
            />
          </div>

         
            <button className="submitButton" type="submit" style={{width: 100, alignSelf: "center"}}>
              Save
            </button>

        </div>
      </form>
    </div>
  );
}
export default UserUpdateForm;

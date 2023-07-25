import { useState, useEffect } from "react";
function useUserById() {
    const [users, setUsers] = useState();

    useEffect(() => {
        const dataFetch = async () => {
            const data = await (
                await fetch(
                    "http://localhost:0420/user/getById"
                )
            ).json();
            setUsers(data);
        };

        dataFetch();
    }, []);
    return users;
}

export default useUserById;
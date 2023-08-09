import { useState, useEffect } from "react";
function useAllUsers() {
    const [users, setUsers] = useState();

    useEffect(() => {
        const dataFetch = async () => {
            const data = await (
                await fetch(
                    "/user"
                )
            ).json();
            setUsers(data);
        };

        dataFetch();
    }, []);
    return users;
}

export default useAllUsers;
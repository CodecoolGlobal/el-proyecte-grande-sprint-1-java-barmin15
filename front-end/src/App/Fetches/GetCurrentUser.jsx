import { useState, useEffect } from "react";
function useCurrentUser() {
    const [user, setUser] = useState(null);

    useEffect(() => {
        const dataFetch = async () => {
            const data = await (
                await fetch(
                    "http://localhost:0420/user/current"
                )
            ).json();
            setUser(data);
        };

        dataFetch();
    }, []);
    return user;
}

export default useCurrentUser;
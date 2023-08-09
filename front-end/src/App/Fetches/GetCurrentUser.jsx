import { useState, useEffect } from "react";
function useCurrentUser() {
    const [user, setUser] = useState(null);

    useEffect(() => {
        const dataFetch = async () => {
            const data = await (
                await fetch(
                    "/user/current"
                )
            ).json();
            setUser(data);
        };

        dataFetch();
    }, []);
    return user;
}

export default useCurrentUser;
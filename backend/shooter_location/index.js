module.exports = async function (context, req) {
    context.log('Shooter Location Request Processed');
    let responseJSON = {
        lat: 25.75562,
        long: -80.3726,
        confindence: 10,
        timestamp: Date.now()
    };

     context.res = {
            // status: 200, /* Defaults to 200 */
            'Content-Type': 'application/json',
            body: responseJSON
    };
};
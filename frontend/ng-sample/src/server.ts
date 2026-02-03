import {
  AngularNodeAppEngine,
  createNodeRequestHandler,
  isMainModule,
  writeResponseToNodeResponse,
} from '@angular/ssr/node';
import express from 'express';
import { join } from 'node:path';

const browserDistFolder = join(import.meta.dirname, '../browser');

const app = express();
const angularApp = new AngularNodeAppEngine();

// var http = require('http');
// var options = {
//   host: 'localhost:8080',
//   path: '/associates',
// };

// var req = http.get(
//   options,
//   function (res: {
//     statusCode: string;
//     headers: any;
//     on: (
//       arg0: string,
//       arg1: (chunk: any) => void,
//     ) => { (): any; new (): any; on: { (arg0: string, arg1: () => void): void; new (): any } };
//   }) {
//     function binaryToText(binaryString: string) {
//       return binaryString
//         .split(' ') // Split the string into an array of binary numbers
//         .map((binaryNum) => parseInt(binaryNum, 2)) // Convert each binary number (base 2) to a decimal integer
//         .map((decimalNum) => String.fromCharCode(decimalNum)) // Convert each decimal to its corresponding ASCII/Unicode character
//         .join(''); // Join the characters into a single string
//     }
//     // console.log('STATUS: ' + res.statusCode);
//     // console.log('HEADERS: ' + JSON.stringify(res.headers));

//     // Buffer the body entirely for processing as a whole.
//     var bodyChunks: any[] = [];
//     res
//       .on('data', function (chunk: any) {
//         // You can process streamed parts here...
//         bodyChunks.push(chunk);
//       })
//       .on('end', function () {
//         var body = Buffer.concat(bodyChunks);
//         // console.log('BODY: ' + body);
//         var data = binaryToText(body.toString('utf-8'));
//         // console.log(data);
//         // ...and/or process the entire body here.
//         // console.log(body);
//       });
//   },
// );

// req.on('error', function (e: { message: string }) {
//   console.log('ERROR: ' + e.message);
// });

/**
 * Example Express Rest API endpoints can be defined here.
 * Uncomment and define endpoints as necessary.
 *
 * Example:
 * ```ts
 * app.get('/api/{*splat}', (req, res) => {
 *   // Handle API request
 * });
 * ```
 */

/**
 * Serve static files from /browser
 */
app.use(
  express.static(browserDistFolder, {
    maxAge: '1y',
    index: false,
    redirect: false,
  }),
);

/**
 * Handle all other requests by rendering the Angular application.
 */
app.use((req, res, next) => {
  angularApp
    .handle(req)
    .then((response) => (response ? writeResponseToNodeResponse(response, res) : next()))
    .catch(next);
});

/**
 * Start the server if this module is the main entry point, or it is ran via PM2.
 * The server listens on the port defined by the `PORT` environment variable, or defaults to 4000.
 */
if (isMainModule(import.meta.url) || process.env['pm_id']) {
  const port = process.env['PORT'] || 4000;
  app.listen(port, (error) => {
    if (error) {
      throw error;
    }

    console.log(`Node Express server listening on http://localhost:${port}`);
  });
}

/**
 * Request handler used by the Angular CLI (for dev-server and during build) or Firebase Cloud Functions.
 */
export const reqHandler = createNodeRequestHandler(app);

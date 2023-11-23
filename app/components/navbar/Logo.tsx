'use client';

import Image from 'next/image';
import React from 'react';

const Logo = () => {
  return <Image alt='Logo' src='images/logo.svg' width={100} height={80} className='hidden md:block cursor-pointer' />;
};

export default Logo;
